angular.module('money').controller('CashFlowController', function ($http, $routeParams, $scope) {
    $scope.categories = [];
    $scope.movements = [];
    $scope.movement = {};
    $scope.bankAccount = {};
    $scope.values = {};
    $scope.values.positive = 0;
    $scope.values.negative = 0;
    $scope.map = {};

    $scope.loaDefaultValues = function () {
        $scope.movement.date = currentDate();
    }

    $scope.getAccount = function () {
        $http.get(
            'cashFlow/accountById?accountId='
            + $scope.bankAccount.id).success(
            function (data) {
                $scope.bankAccount = data.bankAccount;
            });
    }

    $scope.movementsList = function () {
        $http.get(
            'cashFlow/movementsList?accountId='
            + $scope.bankAccount.id).success(
            function (data) {
                $scope.movements = data.list;
            });
    }

    $scope.add = function () {
        $scope.movement.idBankAccount = $scope.bankAccount.id;
        $scope.movement.value = parseFloat($scope.movement.value);

        $http.post('cashFlow/add', $scope.movement).success(
            function (data) {
                $scope.movementsList();
                $scope.movement = {};
                $scope.loaDefaultValues();
                $scope.getAccount();
            });
    }

    $scope.consolidate = function (movement) {
        if (movement.value > 0) {
            $scope.values.positive = $scope.values.positive
                + movement.value;
        } else {
            $scope.values.negative = $scope.values.negative
                + movement.value;
        }

        if (movement.category.description in $scope.map === true) {
            $scope.map[movement.category.description] = $scope.map[movement.category.description]
                + movement.value;
        } else {
            $scope.map[movement.category.description] = movement.value;
        }
    }


    $scope.initCashFlow=function(){
        $scope.bankAccount.id = $routeParams.accountId;

        $scope.loaDefaultValues();
        $scope.getAccount();
        $scope.movementsList();

        $http.get('category/list').success(function (data) {
            $scope.categories = data.list;
        });
    }
});
