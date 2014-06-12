package com.lynxwork.hcm.profile.model;

import java.io.Serializable;

public class Skill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7032212348757871450L;
	
	private String skillId;
	private String name;
	private String description;
	private Integer yearsExperience;
	private Integer levelKnowledge;
	private String skillTypeId;

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
	public Integer getYearsExperience() {
		return yearsExperience;
	}
	public void setYearsExperience(Integer yearsExperience) {
		this.yearsExperience = yearsExperience;
	}
	public Integer getLevelKnowledge() {
		return levelKnowledge;
	}
	public void setLevelKnowledge(Integer levelKnowledge) {
		this.levelKnowledge = levelKnowledge;
	}
	public String getSkillTypeId() {
		return skillTypeId;
	}
	public void setSkillTypeId(String skillTypeId) {
		this.skillTypeId = skillTypeId;
	}
	public String getSkillId() {
		return skillId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	
	
	
}
