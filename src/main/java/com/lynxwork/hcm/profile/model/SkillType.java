package com.lynxwork.hcm.profile.model;

import java.io.Serializable;

public class SkillType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7084088760201245603L;
	
	private String skillTypeId;
	private String name;
	private String description;

	public String getSkillTypeId() {
		return skillTypeId;
	}
	public void setSkillTypeId(String skillTypeId) {
		this.skillTypeId = skillTypeId;
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
	
	
}
