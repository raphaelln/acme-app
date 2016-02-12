package com.raphaelln.acme.model;

import java.io.Serializable;

public abstract class AbstractDocument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1993460250006620403L;

	public abstract String getId();

	public abstract void setId(String id);
}
