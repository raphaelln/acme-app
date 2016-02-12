'use strict';

acmeApp.controller('CountryEditController',function($scope,$location,$routeParams,Country){
	
	$scope.errorMessage=null;

    $scope.updateCountry=function(){
    	$scope.submitting = true;
    	$scope.country.$update(function(){
			$scope.submitting = false;
			$location.path("/countries")
		}, function(error){
			$scope.submitting = false;
			$scope.errorMessage = error.data.message;
		}
		);
    };

    $scope.loadCountry=function(){
        $scope.country=Country.get({id:$routeParams.id});
    };

    $scope.loadCountry();
});