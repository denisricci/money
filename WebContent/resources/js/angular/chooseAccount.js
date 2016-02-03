(function() {
	var app = angular.module('module-choose-account', []);
	app.controller('ChooseAccountController', ['$http', function($http) {
		var controller = this;
		controller.accounts = [];
		$http.get('../bankAccount/list').success(function(data) {
			controller.accounts = data;
		});
		
	} ]);
})();