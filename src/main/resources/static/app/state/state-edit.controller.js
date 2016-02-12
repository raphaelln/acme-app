'use strict';

acmeApp.controller('StateEditController',function($scope,$location,$routeParams,State,Country){
	
	$scope.errorMessage= null;
	$scope.countries=Country.query();

    $scope.updateState=function(){
    	$scope.submitting = true;
        $scope.state.$update(function(){
        	$location.path("/states");
        	$scope.submitting = false;
        }, function(error){
			$scope.submitting = false;
			$scope.errorMessage = error.data.message;
		});
    };

    $scope.loadState=function(){
        $scope.state=State.get({id:$routeParams.id});
    };

    $scope.loadState();
});