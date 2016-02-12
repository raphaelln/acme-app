package com.raphaelln.acme.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@TypeAlias("country")
public class Country extends AbstractDocument {

	@Id
	private String id;

	@NotNull(message = "Country code is required!")
	@Indexed(unique = true)
	private String code;

	@NotNull(message = "Country name is required!")
	@Indexed(unique = true)
	private String name;

	public String getCode() {
		return code;
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

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
