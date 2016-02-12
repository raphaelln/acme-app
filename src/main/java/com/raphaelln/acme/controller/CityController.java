package com.raphaelln.acme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.raphaelln.acme.model.City;
import com.raphaelln.acme.service.AbstractCRUDService;
import com.raphaelln.acme.service.CityService;

@RestController()
@RequestMapping("/api/city")
public class CityController extends AbstractCRUDController<City, String> {

	@Autowired
	private CityService cityService;

	@Override
	AbstractCRUDService<City, String> getService() {
		return cityService;
	}

	@RequestMapping(value = "state/{stateId}", method = RequestMethod.GET)
	public List<City> listByState(@PathVariable("stateId") String stateId) {
		return this.cityService.findByState(stateId);
	}

}
