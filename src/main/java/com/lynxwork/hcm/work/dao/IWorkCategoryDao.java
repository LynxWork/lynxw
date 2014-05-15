package com.lynxwork.hcm.work.dao;

import java.util.List;

import com.lynxwork.hcm.work.model.WorkCategory;

public interface IWorkCategoryDao {

	public List<WorkCategory> findByCountry(String countryId);
}
