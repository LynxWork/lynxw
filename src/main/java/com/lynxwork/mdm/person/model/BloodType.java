package com.lynxwork.mdm.person.model;

import java.io.Serializable;
public class BloodType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5516528077850010344L;
	
	private String bloodTypeId;
	private String bloodType;
	private String description;
	private String observations;
	private String createData;
	private String creatorId;
	private String creatorIp;
	private String lastUpdateDate;
	private String lastUpdaterId;
	private String lastUpdaterIp;
	private String countryId;
	
	public String getBloodTypeId() {
		return bloodTypeId;
	}
	public void setBloodTypeId(String bloodTypeId) {
		this.bloodTypeId = bloodTypeId;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
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
	public String getCreateData() {
		return createData;
	}
	public void setCreateData(String createData) {
		this.createData = createData;
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
	public String getLastUpdaterId() {
		return lastUpdaterId;
	}
	public void setLastUpdaterId(String lastUpdaterId) {
		this.lastUpdaterId = lastUpdaterId;
	}
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getLastUpdaterIp() {
		return lastUpdaterIp;
	}
	public void setLastUpdaterIp(String lastUpdaterIp) {
		this.lastUpdaterIp = lastUpdaterIp;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	
	
	

}
