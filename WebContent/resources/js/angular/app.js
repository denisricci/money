(function() {
	var app = angular.module('money', []);

	app.controller('MoneyController', [ '$http', function($http) {
		var money = this;
		money.accounts = [];
		money.banks = [];

		$http.get('bankAccount/bankList').success(function(data) {
			money.banks = data;
		});
				
		money.listAccounts = function() {
			$http.get('bankAccount/list').success(function(data) {
				money.accounts = data;
			});
		}			

		money.remove = function(account) {
			$http.post('bankAccount/remove', account).success(function(data) {
				money.listAccounts();
			});
		};

		money.listAccounts();

	} ]);
})();