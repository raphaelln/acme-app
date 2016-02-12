'use strict';

acmeApp.controller('CompanyEditController',function($scope,$location,$routeParams,State,Country,Company,City){
	
	$scope.countries=Country.query();
	$scope.errorMessage= null;

    $scope.updateCompany=function(){
    	$scope.submitting = true;
        $scope.Company.$update(function(){
        	$location.path("/companies");
        	$scope.submitting = false;
        }, function(error){
			$scope.submitting = false;
			$scope.errorMessage = error.data.message;
		});
    };

    $scope.loadCompany=function(){
    	$scope.Company=Company.get({id:$routeParams.id}, function(data) {
    		$scope.countryChanged(data.city.state.country.id);
    		$scope.stateChanged(data.city.state.id);
    		$scope.company = data;
    		$scope.selectedCountry=data.city.state.country.id;
    		$scope.selectedState=data.city.state.id;
        });
        
    };

    $scope.loadCompany();
    
    $scope.countryChanged=function(selectedCountry){
    	
    	State.loadByCountry({countryId:selectedCountry}, function(data) {
    		$scope.states = data;
    	}, function(data) {
    		$scope.states = [];
    	});
    }
    
    $scope.stateChanged=function(selectedState){
    	
    	City.loadByState({stateId:selectedState}, function(data) {
    		$scope.cities = data;
    	}, function(data) {
    		$scope.cities = [];
    	});
    }
    
    $scope.addOwnerRow = function() {
		
    	if (!$scope.company.owners) {
			$scope.company.owners = [];
		}
    	
		$scope.company.owners.push("");
	 }

	 $scope.removeOwnerRow = function(owner) {
		 if ($scope.company.owners) {
			 $scope.company.owners.pop(owner);
		 }
	 }
 
 
});