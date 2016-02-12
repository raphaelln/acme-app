'use strict';

acmeApp.controller('CountryViewController',function($scope,$routeParams,Country){
    $scope.country=Country.get({id:$routeParams.id});
});