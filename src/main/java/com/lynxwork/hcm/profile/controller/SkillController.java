package com.lynxwork.hcm.profile.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.lynxwork.hcm.profile.model.Skill;

/**
 * Managed Skill of person profile
 *
 * @author Juan Arturo Vargas Torres
 */
@ManagedBean(name = "skillController")
@SessionScoped
public class SkillController {

	private Skill skill;
	private List<Skill> skills;
	
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	} 

	/**
	 * Find a Skill by Name 
	 * @author Juan Arturo Vargas Torres
	 */
	public String findSkillName(){
		return "";
	}

	public String editSkillName(){
		return "";
	}
	
	public String saveSkillName(){
		return "";
	}
	
	public String cancelSkillName(){
		return "";
	}
}
