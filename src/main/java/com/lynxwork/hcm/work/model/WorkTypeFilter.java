package com.lynxwork.hcm.work.model;

import java.io.Serializable;

import com.lynxwork.common.model.Calendar;

public class WorkTypeFilter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5945001496461346053L;
	private String _id;
	private String countryId;
	private String stateId;
	private String workCategoryId;
	private String workTypeId;
	private Calendar publishOfferDate;
	private float salary; 
	
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public String getWorkCategoryId() {
		return workCategoryId;
	}
	public void setWorkCategoryId(String workCategoryId) {
		this.workCategoryId = workCategoryId;
	}
	public String getWorkTypeId() {
		return workTypeId;
	}
	public void setWorkTypeId(String workTypeId) {
		this.workTypeId = workTypeId;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public Calendar getPublishOfferDate() {
		return publishOfferDate;
	}
	public void setPublishOfferDate(Calendar publishOfferDate) {
		this.publishOfferDate = publishOfferDate;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}

}
