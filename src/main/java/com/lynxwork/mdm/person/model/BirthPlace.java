package com.lynxwork.mdm.person.model;

import java.io.Serializable;

import com.lynxwork.mdm.address.model.Country;
import com.lynxwork.mdm.address.model.State;

public class BirthPlace implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5480202302417877612L;
	private Country country;
	private State   state;
	private String  description;
	private String  observation;
	private String  createDate;
	private String  countryId;
	private String  creatorId;
	private String  creatorIp;
	private String  lastUpdateDate;
	private String  lastUpdaterId;
	private String  lastUpdaterIp;
	
	
	
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public String getCreatorIp() {
		return creatorIp;
	}
	public void setCreatorIp(String creatorIp) {
		this.creatorIp = creatorIp;
	}
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getLastUpdaterId() {
		return lastUpdaterId;
	}
	public void setLastUpdaterId(String lastUpdaterId) {
		this.lastUpdaterId = lastUpdaterId;
	}
	public String getLastUpdaterIp() {
		return lastUpdaterIp;
	}
	public void setLastUpdaterIp(String lastUpdaterIp) {
		this.lastUpdaterIp = lastUpdaterIp;
	}
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
}
