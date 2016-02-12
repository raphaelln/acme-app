package com.raphaelln.acme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.raphaelln.acme.model.Country;

@Repository
public interface CountryRepository extends MongoRepository<Country, String> {

}