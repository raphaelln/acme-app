package com.raphaelln.acme.model;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@TypeAlias("company")
public class Company extends AbstractDocument implements Serializable {

	private static final long serialVersionUID = -2489255854912222922L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	private String id;

	/**
	 * Company name
	 */
	@NotNull(message = "Company name is required!")
	private String name;

	/**
	 * Address of the company
	 */
	@NotNull(message = "Address name is required!")
	private String address;

	/**
	 * City of the company
	 */
	@NotNull(message = "City is required!")
	@DBRef
	private City city;

	/**
	 * Email of the company
	 */
	private String email;

	/**
	 * Phone number
	 */
	private String phoneNumber;

	/**
	 * Owners
	 */
	private Set<String> owners;

	public String getAddress() {
		return address;
	}

	public City getCity() {
		return city;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<String> getOwners() {
		return owners;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwners(Set<String> owners) {
		this.owners = owners;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
