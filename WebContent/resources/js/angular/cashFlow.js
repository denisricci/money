(function() {
	var app = angular.module('module-cash-flow', []);
	app.controller('CashFlowController', ['$http', function($http) {
		var controller = this;						
		controller.categories = [];
		controller.movement={};
		controller.movement.date=currentDate();
		controller.movement.operation='DEBIT';
		
		$http.get('categoriesList').success(function(data) {
			controller.categories = data;
		});

		controller.add = function() {
			$http.post('add', controller.movement).success(function(date) {
				alert('salvou');
			});
		}
	} ]);
})();