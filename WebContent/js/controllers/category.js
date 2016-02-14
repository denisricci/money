angular.module('money').controller('CategoryController',
		function($http, $scope) {
			$scope.categories = [];
			$scope.category = {};
			$scope.category.operation = 'DEBIT';

			$scope.list = function() {
				$http.get('category/list').success(function(data) {
					$scope.categories = data.list;
				});
			}

			$scope.remove = function(category) {
				$http.post('category/remove', category).success(function(data) {
					$scope.list();
				});
			};

			$scope.save = function(category) {
				$http.post('category/save', category).success(function(data) {
					category.id = data.integer;
					$scope.categories.push(category);
					$scope.category = {};
					$scope.category.operation = 'DEBIT';
				});
			}

			$scope.initCategory=function(){
				$scope.list();
			}
		});
