package com.lynxwork.mdm.address.model;

import java.io.Serializable;
import java.util.Date;

public class DistrictType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3273683601516740118L;
	private String districtTypeId;
	private String name;
	private String description;
	private String creatorId;
	private String creatorIp;
	private Date lastUpdateDate;
	private String lastUpdaterId;
	private String lastUpdaterIp;
	public String getDistrictTypeId() {
		return districtTypeId;
	}
	public void setDistrictTypeId(String districtTypeId) {
		this.districtTypeId = districtTypeId;
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
	
	
}
