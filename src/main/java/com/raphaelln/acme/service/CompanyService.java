package com.raphaelln.acme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.raphaelln.acme.model.Company;
import com.raphaelln.acme.repository.CompanyRepository;

@Service
public class CompanyService extends AbstractCRUDService<Company, String> {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	MongoRepository<Company, String> getRepository() {
		return companyRepository;
	}

}
