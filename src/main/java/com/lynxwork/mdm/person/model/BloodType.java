package com.lynxwork.mdm.person.model;

import java.util.Date;

public class BloodType {
	
	private String bloodTypeId;
	private String bloodype;
	private String description;
	private String observations;
	private Date createData;
	private int creatorId;
	private int creatoIp;
	private String lastUpdateDate;
	private Date lastUpdaterId;
	private String lastUpdaterIp;
	
	public String getBloodTypeId() {
		return bloodTypeId;
	}
	public void setBloodTypeId(String bloodTypeId) {
		this.bloodTypeId = bloodTypeId;
	}
	public String getBloodype() {
		return bloodype;
	}
	public void setBloodype(String bloodype) {
		this.bloodype = bloodype;
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
	public Date getCreateData() {
		return createData;
	}
	public void setCreateData(Date createData) {
		this.createData = createData;
	}
	public int getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}
	public int getCreatoIp() {
		return creatoIp;
	}
	public void setCreatoIp(int creatoIp) {
		this.creatoIp = creatoIp;
	}
	public Date getLastUpdaterId() {
		return lastUpdaterId;
	}
	public void setLastUpdaterId(Date lastUpdaterId) {
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
	
	
	

}
