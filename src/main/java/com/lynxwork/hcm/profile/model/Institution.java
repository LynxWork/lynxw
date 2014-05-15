package com.lynxwork.hcm.profile.model;

import java.io.Serializable;

public class Institution implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2070099641197451737L;
	private String institution;
	private String university;
	private String institutionTypeId;
	
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getInstitutionTypeId() {
		return institutionTypeId;
	}
	public void setInstitutionTypeId(String institutionTypeId) {
		this.institutionTypeId = institutionTypeId;
	}

}
