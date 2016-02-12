'use strict';

acmeApp.config(function($routeProvider,$httpProvider){
	
	$routeProvider.when('/countries', {
		 templateUrl:'app/country/countries.html',
		 ccontroller:'CountryListController'
	}).when('/countries/:id/view', {
		templateUrl : 'app/country/country-view.html',
		controller : 'CountryViewController'
	}).when('/countries/new', {
		templateUrl : 'app/country/country-add.html',
		controller : 'CountryCreateController'
	}).when('/countries/:id/edit', {
		templateUrl : 'app/country/country-edit.html',
		controller : 'CountryEditController'
	}).when('/cities', {
		templateUrl:'app/city/cities.html',
		ccontroller:'CityListController'
	}).when('/cities/:id/view', {
		templateUrl : 'app/city/city-view.html',
		controller : 'CityViewController'
	}).when('/cities/new', {
		templateUrl : 'app/city/city-add.html',
		controller : 'CityCreateController'
	}).when('/cities/:id/edit', {
		templateUrl : 'app/city/city-edit.html',
		controller : 'CityEditController'
	}).when('/states', {
		templateUrl:'app/state/states.html',
		ccontroller:'StateListController'
	}).when('/states/:id/view', {
		templateUrl : 'app/state/state-view.html',
		controller : 'StateViewController'
	}).when('/states/new', {
		templateUrl : 'app/state/state-add.html',
		controller : 'StateCreateController'
	}).when('/states/:id/edit', {
		templateUrl : 'app/state/state-edit.html',
		controller : 'StateEditController'
	}).when('/companies', {
		templateUrl:'app/company/companies.html',
		ccontroller:'CompanyListController'
	}).when('/companies/:id/view', {
		templateUrl : 'app/company/company-view.html',
		controller : 'CompanyViewController'
	}).when('/companies/new', {
		templateUrl : 'app/company/company-add.html',
		controller : 'CompanyCreateController'
	}).when('/companies/:id/edit', {
		templateUrl : 'app/company/company-edit.html',
		controller : 'CompanyEditController'
	});
});
