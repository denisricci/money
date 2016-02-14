angular.module('money').controller('AccountController',
		function($http, $scope) {
			$scope.accounts = {};
			$scope.banks = {};
			$scope.bankAccount = {};

			$scope.save = function(bankAccount) {
				$http.post('bankAccount/save', bankAccount).success(function(data) {
					bankAccount.id = data.integer;
					$scope.accounts.push(bankAccount);
					$scope.bankAccount = {};
				});
			}

			$scope.listAccounts = function() {
				$http.get('bankAccount/list').success(function(data) {
					$scope.accounts = data.list;
				});
			}

			$scope.remove = function(account) {
				$http.post('bankAccount/remove', account).success(function(data) {
					$scope.listAccounts();
				});
			};

			$scope.initBankAccount = function(){
				$scope.listAccounts();
				$http.get('bankAccount/bankList').success(function(data) {
					$scope.banks = data.list;
				});
			}


		});