(function() {
	var app = angular.module('module-bank-account', []);
	app.controller('MoneyController', [ '$http', function($http) {
		var controller = this;
		controller.accounts = [];
		controller.banks = [];

		$http.get('bankList').success(function(data) {
			controller.banks = data;
		});

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

		controller.listAccounts();
	} ]);
})();