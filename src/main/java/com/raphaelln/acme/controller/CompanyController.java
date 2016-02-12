package com.raphaelln.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raphaelln.acme.model.Company;
import com.raphaelln.acme.service.AbstractCRUDService;
import com.raphaelln.acme.service.CompanyService;

@RestController()
@RequestMapping("/api/company")
public class CompanyController extends AbstractCRUDController<Company, String> {

	@Autowired
	private CompanyService companyService;

	@Override
	AbstractCRUDService<Company, String> getService() {
		return companyService;
	}

}
