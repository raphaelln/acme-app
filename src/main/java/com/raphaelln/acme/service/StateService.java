package com.raphaelln.acme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.raphaelln.acme.model.State;
import com.raphaelln.acme.repository.StateRepository;

@Service
public class StateService extends AbstractCRUDService<State, String> {

	@Autowired
	private StateRepository stateRepository;

	public List<State> findByCountry(final String countryId) {
		return stateRepository.findByCountryId(countryId);
	}

	@Override
	MongoRepository<State, String> getRepository() {
		return stateRepository;
	}

    @Override
    public String getModelName() {
        return State.class.getSimpleName();
    }

}
