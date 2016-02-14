package com.raphaelln.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raphaelln.acme.model.Country;
import com.raphaelln.acme.service.AbstractCRUDService;
import com.raphaelln.acme.service.CountryService;

@RestController()
@RequestMapping("/api/country")
public class CountryController extends AbstractCRUDController<Country, String> {

	@Autowired
	private CountryService countryService;

	@Override
	AbstractCRUDService<Country, String> getService() {
		return countryService;
	}
 
}
