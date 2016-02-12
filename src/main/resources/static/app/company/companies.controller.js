'use strict';

acmeApp.controller('CompanyListController',function($scope,$location,Company,$modal){

    $scope.countries=Company.query();
    
    $scope.showDeleteModal=function(company) {
    	$scope.itemSelected=company;
    	$scope.deleteModal= $modal({
    		scope: $scope,
    		templateUrl: 'app/templates/modal.delete.tpl.html',
    		show: true,
    		title: 'Delete Company'
    	});
    	
    	$scope.deleteModal.$promise.then($scope.deleteModal.show);
    }

    $scope.deleteItem=function(company){
    	company.$delete(function(){
    		$scope.itemSelected=null;
    		$scope.deleteModal.hide();
    		$scope.countries=Company.query();
    	});
    }
});