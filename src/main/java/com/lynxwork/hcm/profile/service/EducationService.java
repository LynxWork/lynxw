package com.lynxwork.hcm.profile.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.lynxwork.config.SystemConfig;
import com.lynxwork.hcm.factory.HcmDaoFactory;
import com.lynxwork.hcm.profile.dao.IEducationDao;
import com.lynxwork.hcm.profile.model.Education;

public class EducationService {

static final Logger log = Logger.getLogger(EducationService.class);
	
	public List<Education> findByCountry(String countryId){
		log.debug("init findByCountry");
		List<Education> educationList = new ArrayList<Education>();
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.HUMAN_CAPITAL_PERSISTENT_REPOSITORY);
		IEducationDao educationDao = daoFactory.getEducationDao();
		educationList = educationDao.findByCountry(countryId);
		log.debug("end findByCountry");
		return educationList;
	}

	public Education findById(String educationId){
		log.debug("init findById");
		Education education = new Education();
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.HUMAN_CAPITAL_PERSISTENT_REPOSITORY);
		IEducationDao educationDao = daoFactory.getEducationDao();
		education = educationDao.findById( educationId);
		log.debug("end findById");
		return education;
	}

}
