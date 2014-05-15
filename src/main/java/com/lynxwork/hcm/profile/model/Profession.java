package com.lynxwork.hcm.profile.model;

import java.io.Serializable;
import java.util.List;

public class Profession implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3435643040026768612L;
	private String professionId;
	private String name;
	private String description;
	private String countryId;
	private List <Profession> professionSinonym;
	
	public String getProfessionId() {
		return professionId;
	}
	public void setProfessionId(String professionId) {
		this.professionId = professionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List <Profession> getProfessionSinonym() {
		return professionSinonym;
	}
	public void setProfessionSinonym(List <Profession> professionSinonym) {
		this.professionSinonym = professionSinonym;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

}
