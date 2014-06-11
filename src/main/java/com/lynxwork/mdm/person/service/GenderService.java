package com.lynxwork.mdm.person.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.lynxwork.config.SystemConfig;
import com.lynxwork.hcm.factory.HcmDaoFactory;
import com.lynxwork.mdm.person.dao.IGenderDao;
import com.lynxwork.mdm.person.model.Gender;


public class GenderService {
	static final Logger log = Logger.getLogger(CivilStatusService.class);
	
	public List<Gender> findByCountry(String countryId){
		log.info("init findByCountry");
		List<Gender> genderList = new ArrayList<Gender>();
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		IGenderDao genderDao = daoFactory.getGenderDao();
		genderList = genderDao.findByCountry(countryId);
		log.info("end findByCountry");
		return genderList;
	}
	

}
