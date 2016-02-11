(function() {
	var app = angular.module('module-bank-account', []);
	app.controller('MoneyController', [ '$http', function($http) {
		var controller = this;
		controller.accounts = {};
		controller.banks = {};
		controller.bankAccount={};

		$http.get('bankList').success(function(data) {
			controller.banks = data.list;
		});
		
		controller.save = function(){
			$http.post('save', controller.bankAccount).success(function(data){
				controller.accounts.push(controller.bankAccount);
				controller.bankAccount={};
			});
		}

		controller.listAccounts = function() {
			$http.get('list').success(function(data) {
				controller.accounts = data.list;
			});
		}

		controller.remove = function(account) {
			$http.post('remove', account).success(function(data) {
				controller.listAccounts();
			});
		};

		controller.listAccounts();
	} ]);
})();