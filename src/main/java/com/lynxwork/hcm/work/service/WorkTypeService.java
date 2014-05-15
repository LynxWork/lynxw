package com.lynxwork.hcm.work.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lynxwork.config.SystemConfig;
import com.lynxwork.hcm.factory.HcmDaoFactory;
import com.lynxwork.hcm.work.dao.IWorkTypeDao;
import com.lynxwork.hcm.work.model.WorkType;

public class WorkTypeService {

	static final Logger log = Logger.getLogger(WorkTypeService.class);
	
	public List<WorkType>findByCountryId(String countryId){
		log.debug("Init WorkTypeService.findByCountryId");
		List<WorkType> list = new ArrayList<WorkType>();
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.HUMAN_CAPITAL_PERSISTENT_REPOSITORY);
		IWorkTypeDao dao = daoFactory.getWorkTypeDao();
		list = dao.findByCountryId(countryId);
		log.debug("End WorkTypeService.findByCountryId");
		return list;
	}
	
}
