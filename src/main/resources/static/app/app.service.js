'use strict';

acmeApp.factory('Country',function($resource){
    return $resource('api/country/:id',{id:'@id'},{
        update: {
            method: 'PUT'
        }
    });
}).factory('City',function($resource){
    return $resource('api/city/:id',{id:'@id'},{
        update: {
            method: 'PUT'
        },
        loadByState: {
        	method: 'GET', url: 'api/city/state/:stateId', isArray: true
        }
    });
}).factory('State',function($resource){
    return $resource('api/state/:id',{id:'@id'},{
        update: {
            method: 'PUT'
        },
        loadByCountry: {
        	method: 'GET', url: 'api/state/country/:countryId', isArray: true
        }
    });
}).factory('Company',function($resource){
	return $resource('api/company/:id',{id:'@id'},{
		update: {
			method: 'PUT'
		}
	});
});
    