package com.raphaelln.acme.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.raphaelln.acme.model.City;

@Repository
public interface CityRepository extends MongoRepository<City, String> {

	public List<City> findByStateId(final String stateId);

}