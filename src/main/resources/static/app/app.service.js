'use strict';

acmeApp.factory('Country',function($resource){
    return $resource('http://localhost:8080/api/country/:id',{id:'@id'},{
        update: {
            method: 'PUT'
        }
    });
}).factory('City',function($resource){
    return $resource('http://localhost:8080/api/city/:id',{id:'@id'},{
        update: {
            method: 'PUT'
        },
        loadByState: {
        	method: 'GET', url: 'http://localhost:8080/api/city/state/:stateId', isArray: true
        }
    });
}).factory('State',function($resource){
    return $resource('http://localhost:8080/api/state/:id',{id:'@id'},{
        update: {
            method: 'PUT'
        },
        loadByCountry: {
        	method: 'GET', url: 'http://localhost:8080/api/state/country/:countryId', isArray: true
        }
    });
}).factory('Company',function($resource){
	return $resource('http://localhost:8080/api/company/:id',{id:'@id'},{
		update: {
			method: 'PUT'
		}
	});
});
    