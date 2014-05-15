package com.lynxwork.mdm.person.model;

import java.util.Date;

public class CivilStatus {
	
private String civilStatusId;
private String civilStatus;
private String descriptions;
private String observations;
private String createDate;
private String countryId;
private String creatorId;
private String creatorIp;
private Date lastUpdateDate;
private String lastUpdaterId;
private String lastUpdaterIp;


public String getCivilStatusId() {
	return civilStatusId;
}
public void setCivilStatusId(String civilStatusId) {
	this.civilStatusId = civilStatusId;
}
public String getCivilStatus() {
	return civilStatus;
}
public void setCivilStatus(String civilStatus) {
	this.civilStatus = civilStatus;
}
public String getDescriptions() {
	return descriptions;
}
public void setDescriptions(String descriptions) {
	this.descriptions = descriptions;
}
public String getObservations() {
	return observations;
}
public void setObservations(String observations) {
	this.observations = observations;
}
public String getCreateDate() {
	return createDate;
}
public void setCreateDate(String createDate) {
	this.createDate = createDate;
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
public Date getLastUpdateDate() {
	return lastUpdateDate;
}
public void setLastUpdateDate(Date lastUpdateDate) {
	this.lastUpdateDate = lastUpdateDate;
}

public String getLastUpdaterIp() {
	return lastUpdaterIp;
}
public void setLastUpdaterIp(String lastUpdaterIp) {
	this.lastUpdaterIp = lastUpdaterIp;
}
public String getLastUpdaterId() {
	return lastUpdaterId;
}
public void setLastUpdaterId(String lastUpdaterId) {
	this.lastUpdaterId = lastUpdaterId;
}
public String getCountryId() {
	return countryId;
}
public void setCountryId(String countryId) {
	this.countryId = countryId;
}



}
