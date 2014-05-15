package com.lynxwork.hcm.work.dao;

import java.util.List;

import com.lynxwork.hcm.work.model.WorkType;

public interface IWorkTypeDao {

	public List<WorkType> findByCountryId(String countryId);
	
}
