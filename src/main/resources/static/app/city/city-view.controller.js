'use strict';

acmeApp.controller('CityViewController',function($scope,$routeParams,City){
    $scope.city=City.get({id:$routeParams.id});
});