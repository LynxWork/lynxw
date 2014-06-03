package com.lynxwork.hcm.profile.dao;

import java.util.List;

import com.lynxwork.hcm.profile.model.SkillType;

public interface ISkillTypeDao {

	public List<SkillType> findAll(String countryId, String skillTypeId);

	public boolean save(SkillType skillType);

	public SkillType find(String name);
	
	public SkillType findById(String skillTypeId);

}
