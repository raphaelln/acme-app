package com.raphaelln.acme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.raphaelln.acme.model.Company;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {

}