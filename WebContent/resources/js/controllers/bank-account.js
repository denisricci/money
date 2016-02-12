(function() {
	var app = angular.module('module-bank-account', []);
	app.controller('AccountController', function($http, $scope) {
		var self = this;
		$scope.accounts = {};
		$scope.banks = {};
		$scope.bankAccount={};

		$http.get('bankList').success(function(data) {
			$scope.banks = data.list;
		});
		
		self.save = function(bankAccount){
			$http.post('save', bankAccount).success(function(data){
				bankAccount.id=data.integer;
				$scope.accounts.push(bankAccount);
				$scope.bankAccount={};
			});
		}

		self.listAccounts = function() {
			$http.get('list').success(function(data) {
				$scope.accounts = data.list;
			});
		}

		self.remove = function(account) {
			$http.post('remove', account).success(function(data) {
				self.listAccounts();
			});
		};

		self.listAccounts();
	} );
})();