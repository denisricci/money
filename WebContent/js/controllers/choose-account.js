angular.module('money').controller('ChooseAccountController', function($http,$scope) {
	$scope.accounts = [];

	$scope.initChooseAccount = function(){
		$http.get('../bankAccount/list').success(function(data) {
			$scope.accounts = data.list;
		});
	}
})
