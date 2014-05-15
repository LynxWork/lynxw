package com.lynxwork.hcm.profile.model;

import java.io.Serializable;
import java.util.List;

public class Education implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1015302175180280779L;
	
	private String  educationId;
	private String country;
	private String institution;
	private int degree;
	private String countryId;
	private String profileId;
	private List <Education> EducationSinonym;
	
	public String getEducationId() {
		return educationId;
	}
	public void setEducationId(String educationId) {
		this.educationId = educationId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	public List <Education> getEducationSinonym() {
		return EducationSinonym;
	}
	public void setEducationSinonym(List <Education> educationSinonym) {
		EducationSinonym = educationSinonym;
	}

}
