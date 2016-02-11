(function() {
	var app = angular.module('module-category', []);
	app.controller('CategoryController', function($http, $scope) {
		self = this;
		$scope.categories = [];		
		$scope.category={};

		self.list = function() {
			$http.get('list').success(function(data) {
				$scope.categories = data.list;
			});
		}

		self.remove = function(category) {
			$http.post('remove', category).success(function(data) {
				self.list();
			});
		};

		self.save = function(category) {
			$http.post('save', category).success(function(data) {
				category.id=data.integer;
				$scope.categories.push(category);
				$scope.category={};
			});
		}

		self.list();
	});
})();