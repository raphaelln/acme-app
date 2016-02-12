'use strict';

acmeApp.controller('StateViewController',function($scope,$routeParams,State){
    $scope.state=State.get({id:$routeParams.id});
});