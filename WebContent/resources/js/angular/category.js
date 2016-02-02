(function() {
	var app = angular.module('module-category', []);
	app.controller('CategoryController', [ '$http', function($http) {
		var controller = this;
		controller.categories = [];		

		controller.listCategories = function() {
			$http.get('list').success(function(data) {
				controller.categories = data;
			});
		}

		controller.remove = function(category) {
			$http.post('remove', category).success(function(data) {
				controller.listCategories();
			});
		};

		controller.listCategories();
	} ]);
})();