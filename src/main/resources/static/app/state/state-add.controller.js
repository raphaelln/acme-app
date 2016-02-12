'use strict';

acmeApp.controller('StateCreateController',function($scope,$location,$routeParams,State,Country){

    $scope.state=new State();
    $scope.countries=Country.query();
    $scope.submitting=false;
    $scope.errorMessage= null;
    $scope.selectedCountry=null;

    $scope.addState=function(){
    	$scope.submitting = true;
		$scope.state.$save(function(){
			$scope.submitting = false;
			$location.path("/states")
		}, function(error){
			$scope.submitting = false;
			$scope.errorMessage = error.data.message;
		});
    }

});