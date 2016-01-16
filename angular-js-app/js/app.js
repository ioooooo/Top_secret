var app = angular.module('blog', []);

app.controller('ClientController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/client';

    $scope.clienti = [];
    $scope.fields = [];
    $scope.client = {};


    $scope.client = {};
    $scope.editPerson = {};



    $http.get(url).then(function successCallback(response) {

        $scope.clienti = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.clienti);
        //console.log($scope.fields);

    });
    

    $scope.addPersoana = function(client) {
        client.id = parseInt(client.id);
        console.log(client.id);
        $http({
            method: 'POST',
            url: url,
            data: client
        }).then(function successCallback(response) {
            console.log(response);
            $scope.clienti.push(client);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deletePersoana = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.clienti = $scope.clienti.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdatePerson = function(client) {
        $scope.editPerson = client;
    };


    $scope.updatePerson = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editPerson
        }).then(function successCallback(response) {
            $scope.editPerson = {};
            console.log(response);
             $scope.clienti.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editPerson = {};
            console.log(response);
        });
    };

}]);

app.controller('CarController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/car';

    $scope.cars = [];
    $scope.fields = [];
    $scope.car = {};


    $scope.car = {};
    $scope.editCar = {};



    $http.get(url).then(function successCallback(response) {

        $scope.cars = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.cars);
        console.log($scope.fields);

    });
    

    $scope.addCar = function(car) {
        car.id = parseInt(car.id);
		car.brand = String(car.brand);
		car.model = String(car.model);
		
        console.log(car.id);
        $http({
            method: 'POST',
            url: url,
            data: car
        }).then(function successCallback(response) {
            console.log(response);
            $scope.cars.push(car);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteCar = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.cars = $scope.cars.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateCar = function(car) {
        $scope.editCar = car;
    };


    $scope.updateCar = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editCar
        }).then(function successCallback(response) {
            $scope.editCar = {};
            console.log(response);
             $scope.cars.push($scope.editCar);
            // done.
        }, function errorCallback(response) {
            $scope.editCar = {};
            console.log(response);
        });
    };

}]);