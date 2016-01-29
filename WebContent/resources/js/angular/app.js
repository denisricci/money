(function() {
	var app = angular.module('money', []);
	
	app.controller('MoneyController', function(){
		this.account=santander;
	});

	var santander ={"id":9,"description":"Santander","balance":50000.0,"bank":{"id":"033","name":"Banco Santander (Brasil) S.A.","excluido":0},"excluido":0}
	
})