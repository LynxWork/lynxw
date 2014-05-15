package com.lynxwork.social.graph.engine.model;

import java.util.Date;

public class EntityGraph {

	private String entityGraphId;
	private String entityId;
	private String entityType; //PERSON, GROUP, COMPANY
	private String entityRelationType; //FRIEND COLEGE, EMPLOYEE
	private String entityRelationStatus; //ACTIVE, CANCELED
	
	//Control Filds
	private Date lastUpdatedStamp;
	private Date createStamp;
	private String partnerId;
	
	public String getEntityGraphId() {
		return entityGraphId;
	}
	public void setEntityGraphId(String entityGraphId) {
		this.entityGraphId = entityGraphId;
	}
	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public String getEntityRelationType() {
		return entityRelationType;
	}
	public void setEntityRelationType(String entityRelationType) {
		this.entityRelationType = entityRelationType;
	}
	public Date getLastUpdatedStamp() {
		return lastUpdatedStamp;
	}
	public void setLastUpdatedStamp(Date lastUpdatedStamp) {
		this.lastUpdatedStamp = lastUpdatedStamp;
	}
	public Date getCreateStamp() {
		return createStamp;
	}
	public void setCreateStamp(Date createStamp) {
		this.createStamp = createStamp;
	}
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public String getEntityRelationStatus() {
		return entityRelationStatus;
	}
	public void setEntityRelationStatus(String entityRelationStatus) {
		this.entityRelationStatus = entityRelationStatus;
	}

	
}
