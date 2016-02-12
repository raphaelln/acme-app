package com.raphaelln.acme.model;

import javax.validation.constraints.NotNull;

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
@TypeAlias("state")
public class State extends AbstractDocument {

	@Id
	private String id;

	@NotNull(message = "State name is required!")
	private String name;

	@NotNull(message = "State code is required!")
	private String code;

	@NotNull(message = "Country is required!")
	@DBRef
	private Country country;

	public String getCode() {
		return code;
	}

	public Country getCountry() {
		return country;
	}

	@Override
	public String getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
