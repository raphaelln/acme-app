package com.raphaelln.acme.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.raphaelln.acme.model.State;

@Repository
public interface StateRepository extends MongoRepository<State, String> {

	public List<State> findByCountryId(final String countryId);

}