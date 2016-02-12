package com.raphaelln.acme.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * City document
 *
 * @author raphaelln
 */
@Document
@TypeAlias("city")
public class City extends AbstractDocument {

	@Id
	private String id;

	@NotBlank(message = "City name is required!")
	private String name;

	@NotNull(message = "State is required!")
	@DBRef
	private State state;

	@Override
	public String getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public State getState() {
		return state;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setState(State state) {
		this.state = state;
	}

}
