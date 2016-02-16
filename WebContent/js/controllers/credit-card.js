angular.module('money').controller('CreditCardController',function($scope, $http){
    $scope.creditCard={};
    $scope.creditCards=[];
    $scope.companies=[];
    $scope.accounts=[];        
    
    
    $scope.list = function(){
    	$http.get('creditCard/list').success(function(data){
    		$scope.creditCards=data.list;
    	});    		    	
    }
        
    $scope.initCreditCard = function (){
    	$http.get('creditCard/companies').success(function(data){
    		$scope.companies=data.list;
    	});
    	
    	$scope.listAccounts = function(){
        	$http.get('bankAccount/list').success(function(data){
        		$scope.accounts = data.list;
        	});
        }  
    	
    	$scope.list();
    }
    
    $scope.save = function (){
    	$http.post('creditCard/save', $scope.creditCard).succes(function(data){
    		
    	});
    }        
    
});
