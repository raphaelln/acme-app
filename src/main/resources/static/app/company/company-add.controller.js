'use strict';

acmeApp.controller('CompanyCreateController',function($scope,$location,$routeParams,State,Country,Company,City){

    $scope.company=new Company();
    $scope.submitting=false;
    $scope.errorMessage= null;
    $scope.countries=Country.query();
    

    $scope.addCompany=function(){
    	$scope.submitting = true;
		$scope.company.$save(function(){
			$scope.submitting = false;
			$location.path("/companies")
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