package com.raphaelln.acme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.raphaelln.acme.model.Country;
import com.raphaelln.acme.model.State;
import com.raphaelln.acme.repository.CountryRepository;

@Service
public class CountryService extends AbstractCRUDService<Country, String> {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	MongoRepository<Country, String> getRepository() {
		return countryRepository;
	}

	@Override
	public String getModelName() {
        return Country.class.getSimpleName();
    }
}
