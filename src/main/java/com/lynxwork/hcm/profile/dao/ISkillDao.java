package com.lynxwork.hcm.profile.dao;

import java.util.List;


import com.lynxwork.hcm.profile.model.Skill;

public interface ISkillDao {

	public List<Skill> findByCountry(String countryId, String skillTypeId);

    public List<Skill> find(String countryId, String name);

}