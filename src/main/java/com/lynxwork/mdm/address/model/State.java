package com.lynxwork.mdm.address.model;

import java.io.Serializable;

public class State implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4570811340302053760L;
	private String stateId;
	private String name;
	private String code;
	private String countryId;
	
	
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	
	
}
