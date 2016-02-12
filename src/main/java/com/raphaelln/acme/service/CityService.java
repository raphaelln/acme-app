package com.raphaelln.acme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.raphaelln.acme.model.City;
import com.raphaelln.acme.repository.CityRepository;

@Service
public class CityService extends AbstractCRUDService<City, String> {

	@Autowired
	private CityRepository cityRepository;

	public List<City> findByState(final String stateId) {
		return cityRepository.findByStateId(stateId);
	}

	@Override
	MongoRepository<City, String> getRepository() {
		return cityRepository;
	}

}
