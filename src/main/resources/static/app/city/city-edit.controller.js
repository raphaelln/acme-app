'use strict';

acmeApp.controller('CityEditController',function($scope,$location,$routeParams,City,Country,State){
	
	$scope.countries=Country.query();
	$scope.errorMessage= null;

    $scope.updateCity=function(){
        $scope.City.$update(function(){
        	$location.path("/cities");
        	$scope.submitting = false;
        }, function(error){
			$scope.submitting = false;
			$scope.errorMessage = error.data.message;
		});
    };

    $scope.loadCity=function(){
    	$scope.City=City.get({id:$routeParams.id}, function(data) {
    		$scope.countryChanged(data.state.country.id);
    		$scope.city = data;
    		$scope.selectedCountry=data.state.country.id;
        });
        
    };

    $scope.loadCity();
    
    
    $scope.countryChanged=function(selectedCountry){
    	
    	State.loadByCountry({countryId:selectedCountry}, function(data) {
    		$scope.states = data;
    	}, function(data) {
    		$scope.states = [];
    	});
    }
 
 
});