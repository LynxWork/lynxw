package com.lynxwork.hcm.profile.model;

import java.io.Serializable;

public class InstitutionType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2805416538145850023L;
	private String institutionType;
	private String institutionName;
	private String description;
	
	public String getInstitutionType() {
		return institutionType;
	}
	public void setInstitutionType(String institutionType) {
		this.institutionType = institutionType;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 

}
