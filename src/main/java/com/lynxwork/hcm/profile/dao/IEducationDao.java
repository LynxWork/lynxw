package com.lynxwork.hcm.profile.dao;

import java.util.List;

import com.lynxwork.hcm.profile.model.Education;

public interface IEducationDao {

	public List<Education> findByCountry(String country);
	
	Education findById(String educationId);
	
}
