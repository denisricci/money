(function() {
	var app = angular.module('module-cash-flow', []);
	app.controller('CashFlowController', [ '$http', function($http) {
		var controller = this;
		controller.movement;
		controller.categories = [];

		$http.get('categoriesList').success(function(data) {
			controller.categories = data;
		});
		
		controller.add=function(){			
			$http.post('add', this.movement).success(function(date){
				alert('salvou');
			});
		}

		controller.listAccounts = function() {
			$http.get('list').success(function(data) {
				controller.accounts = data;
			});
		}

		controller.remove = function(account) {
			$http.post('remove', account).success(function(data) {
				controller.listAccounts();
			});
		};		
	} ]);
})();