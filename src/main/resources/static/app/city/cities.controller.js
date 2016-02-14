'use strict';

acmeApp.controller('CityListController',function($scope,$location,City,$modal){

    $scope.countries=City.query();
    
    $scope.showDeleteModal=function(city) {
    	$scope.itemSelected=city;
    	$scope.deleteModal= $modal({
    		scope: $scope,
    		templateUrl: 'app/templates/modal.delete.tpl.html',
    		show: true,
    		title: 'Delete City'
    	});
    	
    	$scope.deleteModal.$promise.then($scope.deleteModal.show);
    }

    $scope.deleteItem=function(city){
    	city.$delete(function(){
    		$scope.itemSelected=null;
    		$scope.deleteModal.hide();
    		$scope.countries=City.query();
    	},function(data) {
    		$scope.itemSelected=null;
    		$scope.deleteModal.hide();
    		$scope.countries=City.query();
    	});
    }
});