'use strict';

acmeApp.controller('CityCreateController',function($scope,$location,$routeParams,City,Country,State){

    $scope.city=new City();
    $scope.submitting=false;
    $scope.errorMessage= null;
    $scope.countries=Country.query();
    

    $scope.addCity=function(){
    	$scope.submitting = true;
		$scope.city.$save(function(){
			$scope.submitting = false;
			$location.path("/cities")
		}, function(error){
			$scope.submitting = false;
			$scope.errorMessage = error.data.message;
		});
    }
    
    $scope.countryChanged=function(selectedCountry){
    	
    	State.loadByCountry({countryId:selectedCountry}, function(data) {
    		$scope.states = data;
    	}, function(data) {
    		$scope.states = [];
    	});
    }

});