package com.lynxwork.hcm.work.service;

import java.util.ArrayList;
import java.util.List;

import com.lynxwork.config.SystemConfig;
import com.lynxwork.hcm.factory.HcmDaoFactory;
import com.lynxwork.hcm.work.dao.IWorkCategoryDao;
import com.lynxwork.hcm.work.model.WorkCategory;

public class WorkCategoryService {

	public List<WorkCategory> findWorkCategoryByCountryId(String countryId){
		List<WorkCategory> workCategoryList = new ArrayList<WorkCategory>();
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.HUMAN_CAPITAL_PERSISTENT_REPOSITORY);
		IWorkCategoryDao workCategoryDao = daoFactory.getWorkCategoryDao();
		workCategoryList = workCategoryDao.findByCountry(countryId);
		return workCategoryList;
	}

}
