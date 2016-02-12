'use strict';

var acmeApp = angular.module('acmeApp',['ui.mask','ngRoute','ngResource','jcs-autoValidate','angular-ladda','mgcrea.ngStrap'])

acmeApp.run(function($location){
   $location.path("/companies");
});