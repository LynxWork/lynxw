package com.lynxwork.mdm.address.model;

import java.io.Serializable;

public class AddressType  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4291073492163874532L;
	private String name;
	private String addreessTypeId;
	private String addreessType;
    private String description;
    private String observations;
    
	public String getAddreessTypeId() {
		return addreessTypeId;
	}
	public void setAddreessTypeId(String addreessTypeId) {
		this.addreessTypeId = addreessTypeId;
	}
	public String getAddreessType() {
		return addreessType;
	}
	public void setAddreessType(String addreessType) {
		this.addreessType = addreessType;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}
