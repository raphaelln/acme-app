package com.raphaelln.acme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.raphaelln.acme.exception.AcmeBusinessException;
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

	@Override
	public String getModelName() {
        return Company.class.getSimpleName();
    }
	
	public void addOwner(final String companyId, final String owner) throws AcmeBusinessException {
	    
	    if (companyRepository.exists(companyId)) {
	        final Company company = companyRepository.findOne(companyId);
	        if (company.getOwners().contains(owner)) {
	           throw new AcmeBusinessException("Owner already exists!"); 
	        }
	        company.getOwners().add(owner);
	        companyRepository.save(company);
	    } else {
	        throw new AcmeBusinessException("Company not found !"); 
	    }
	}

}
