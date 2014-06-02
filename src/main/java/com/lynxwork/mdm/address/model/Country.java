package com.lynxwork.mdm.address.model;

import java.io.Serializable;

public class Country implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5613991425834183163L;
	
	private String countryId;
	private String name;
	private String acronym;
	
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getAcronym() {
		return acronym;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
