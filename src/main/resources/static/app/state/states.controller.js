'use strict';

acmeApp.controller('StateListController',function($scope,$location,State,$modal){

    $scope.countries=State.query();
    
    $scope.showDeleteModal=function(state) {
    	$scope.itemSelected=state;
    	$scope.deleteModal= $modal({
    		scope: $scope,
    		templateUrl: 'app/templates/modal.delete.tpl.html',
    		show: true,
    		title: 'Delete State'
    	});
    	
    	$scope.deleteModal.$promise.then($scope.deleteModal.show);
    }

    $scope.deleteItem=function(state){
    	state.$delete(function(){
    		$scope.itemSelected=null;
    		$scope.deleteModal.hide();
    		$scope.countries=State.query();
    	});
    }
});