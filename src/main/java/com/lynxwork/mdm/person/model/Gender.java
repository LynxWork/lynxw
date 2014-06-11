package com.lynxwork.mdm.person.model;

import java.io.Serializable;

public class Gender implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6750698028423803540L;
	private String genderId;
	private String gender;
	private String description;
	private String observations;
	
	public String getGenderId() {
		return genderId;
	}
	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	
}
