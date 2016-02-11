(function() {	
	var app = angular.module('module-cash-flow', ['custonsFilters']);
	app.controller('CashFlowController', ['$http', '$location', function($http, $location) {
		var controller = this;						
		controller.categories = [];
		controller.movements=[];
		controller.movement={};		
		controller.bankAccount={};
		controller.values={};
		controller.values.positive = 0;
		controller.values.negative = 0;
		controller.map={};
		
		controller.bankAccount.id=getParameterByName('accountId', document.URL);		
		
		controller.loaDefaultValues=function(){
			controller.movement.date=currentDate();
			controller.movement.operation='DEBIT';
		}
		
		controller.getAccount=function(){
			$http.get('accountById?accountId='+ controller.bankAccount.id).success(function(data){
				controller.bankAccount=data.bankAccount;
			});
		}
		
		controller.loaDefaultValues();
		controller.getAccount();
		
		$http.get('../category/list').success(function(data){
			controller.categories=data.list;
		});
		
		
		
		$http.get('movementsList?accountId=' + controller.bankAccount.id).success(function(data) {
			controller.movements = data.list;
		});

		controller.add = function() {
			controller.movement.idBankAccount=controller.bankAccount.id;
			if(controller.movement.operation==='DEBIT'){
				controller.movement.value=parseFloat(controller.movement.value) * -1;
			}
			$http.post('add', controller.movement).success(function(data) {							
				controller.movements.push(controller.movement);
				controller.movement={};
				controller.loaDefaultValues();
				controller.getAccount();
			});
		}
		
		controller.consolidate=function(movement){
			if(movement.value > 0){
				controller.values.positive = controller.values.positive + movement.value;
			}else{
				controller.values.negative = controller.values.negative + movement.value;
			}
						
			if(movement.category.description in controller.map === true){
				controller.map[movement.category.description] = controller.map[movement.category.description]+ movement.value;
			}else{
				controller.map[movement.category.description] = movement.value;
			}		
		}
	} ]);
})();