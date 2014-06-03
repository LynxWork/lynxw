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
@ManagedBean(name = "professionController")
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

}
