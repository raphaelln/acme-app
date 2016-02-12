package com.raphaelln.acme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.raphaelln.acme.model.City;
import com.raphaelln.acme.model.Company;
import com.raphaelln.acme.model.Country;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {

}