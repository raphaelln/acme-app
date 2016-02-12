'use strict';

acmeApp.controller('CountryCreateController',function($scope,$location,$routeParams,Country){

    $scope.country=new Country();
    $scope.submitting=false;
    $scope.errorMessage= null;

    $scope.addCountry=function(){
    	$scope.errorMessage = null;
    	$scope.submitting = true;
		$scope.country.$save(function(){
			$scope.submitting = false;
			$location.path("/countries")
		}, function(error){
			$scope.submitting = false;
			$scope.errorMessage = error.data.message;
		}
		);
    }
});