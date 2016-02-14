angular.module('money', ['ngRoute']).config(function ($routeProvider) {
    $routeProvider.when('/category', {
        templateUrl: 'partials/category.html',
        controller: 'CategoryController'
    });

    $routeProvider.when('/bankAccount', {
        templateUrl: 'partials/bankAccount.html',
        controller: 'AccountController'
    });

    $routeProvider.when('/cashFlow/account/:accountId', {
        templateUrl: 'partials/cashFlow.html',
        controller: 'CashFlowController'
    });

    $routeProvider.when('/menu', {
        templateUrl: 'partials/menu.html',
        controller: 'CashFlowController'
    });

    $routeProvider.when('/chooseAccount', {
        templateUrl: 'partials/chooseAccount.html',
        controller: 'ChooseAccountController'
    });

    $routeProvider.otherwise({redirectTo:'/menu'});

});