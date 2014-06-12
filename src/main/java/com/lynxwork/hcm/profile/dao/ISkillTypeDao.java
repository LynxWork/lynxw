package com.lynxwork.hcm.profile.dao;

import java.util.List;

import org.bson.types.ObjectId;

import com.lynxwork.hcm.profile.model.SkillType;
import com.lynxwork.persistance.exception.SaveEntityException;

public interface ISkillTypeDao {

	public List<SkillType> findAll(String countryId, String skillTypeId);

	public ObjectId save(SkillType skillType) throws SaveEntityException;

	public SkillType find(String name);
	
	public SkillType findById(String skillTypeId);

	public List<SkillType> findByCountry(String countryId, String skillTypeId);

}
