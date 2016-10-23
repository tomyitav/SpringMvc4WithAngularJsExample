'use strict';

/**
 * CarController
 * @constructor
 */
var CarController = function($scope, $http) {
    $scope.car = {};
    $scope.editMode = false;

    $scope.fetchCarsList = function() {
        $http.get('cars/carlist.json').success(function(carList){
            $scope.cars = carList;
        });
    };

    $scope.addNewCar = function(car) {

        $http.post('cars/addCar', car).success(function() {
            $scope.fetchCarsList();
            $scope.car.name = ''
        }).error(function() {
            $scope.setError('Could not add a new car');
        });
    };

    $scope.removeCar = function(car) {
        $http.delete('cars/removeCar/' + car).success(function() {
            $scope.fetchCarsList();
        });
        $scope.car.name = '';
    };

    $scope.removeAllCars = function() {
        $http.delete('cars/removeAllCars').success(function() {
            $scope.fetchCarsList();
        });

    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchCarsList();

    $scope.predicate = 'id';
};