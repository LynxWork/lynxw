package com.lynxwork.mdm.person.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lynxwork.config.SystemConfig;
import com.lynxwork.hcm.factory.HcmDaoFactory;
import com.lynxwork.mdm.person.dao.IBloodTypeDao;
import com.lynxwork.mdm.person.model.BloodType;

public class BloodTypeService {
	static final Logger log = Logger.getLogger(BloodTypeService.class);
	
	public List<BloodType> findByCountry(String countryId){
		log.info("init findByCountry");
		List<BloodType> bloodTypeList = new ArrayList<BloodType>();
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		IBloodTypeDao bloodTypeDao = daoFactory.getBloodTypeDao();
		bloodTypeList = bloodTypeDao.findByCountry(countryId);
		log.info("end findByCountry");
		return bloodTypeList;
	}
	


}
