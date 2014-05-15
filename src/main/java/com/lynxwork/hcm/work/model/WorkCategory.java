package com.lynxwork.hcm.work.model;

import java.io.Serializable;

public class WorkCategory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7527308796821714570L;
	private String _id;
	private String workCategoryId;
	private String name;
	private String description;
	private String countryId;
	
	public String getWorkCategoryId() {
		return workCategoryId;
	}
	public void setWorkCategoryId(String workCategoryId) {
		this.workCategoryId = workCategoryId;
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
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}

}
