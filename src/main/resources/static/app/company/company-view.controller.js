'use strict';

acmeApp.controller('CompanyViewController',function($scope,$routeParams,Company){
    $scope.company=Company.get({id:$routeParams.id});
});