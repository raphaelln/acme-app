package com.raphaelln.acme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.raphaelln.acme.model.State;
import com.raphaelln.acme.service.AbstractCRUDService;
import com.raphaelln.acme.service.StateService;

@RestController()
@RequestMapping("/api/state")
public class StateController extends AbstractCRUDController<State, String> {

	@Autowired
	private StateService stateService;

	@Override
	AbstractCRUDService<State, String> getService() {
		return stateService;
	}

	@RequestMapping(value = "country/{countryId}", method = RequestMethod.GET)
	public List<State> listByCountry(@PathVariable("countryId") String countryId) {
		return this.stateService.findByCountry(countryId);
	}

}
