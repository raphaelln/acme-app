'use strict';

acmeApp.controller('CountryListController',function($scope,$location,Country,$modal){

    $scope.countries=Country.query();
    
    $scope.showDeleteModal=function(country) {
    	$scope.itemSelected=country;
    	$scope.deleteModal= $modal({
    		scope: $scope,
    		templateUrl: 'app/templates/modal.delete.tpl.html',
    		show: true,
    		title: 'Delete Country'
    	});
    	
    	$scope.deleteModal.$promise.then($scope.deleteModal.show);
    }

    $scope.deleteItem=function(country){
    	country.$delete(function(data) {
    		$scope.itemSelected=null;
    		$scope.deleteModal.hide();
    		$scope.countries=Country.query();
    	},function(data) {
    		$scope.itemSelected=null;
    		$scope.deleteModal.hide();
    		$scope.countries=Country.query();
    	});
    }
});