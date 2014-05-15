package com.lynxwork.hcm.profile.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lynxwork.config.SystemConfig;
import com.lynxwork.hcm.factory.HcmDaoFactory;
import com.lynxwork.hcm.profile.dao.IProfessionDao;
import com.lynxwork.hcm.profile.model.Profession;

public class ProfessionService {

	static final Logger log = Logger.getLogger(ProfessionService.class);
	
	public List<Profession> findByCountry(String countryId){
		log.debug("init findByCountry");
		List<Profession> professionList = new ArrayList<Profession>();
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.HUMAN_CAPITAL_PERSISTENT_REPOSITORY);
		IProfessionDao professionDao = daoFactory.getProfessionDao();
		professionList = professionDao.findByCountry( countryId);
		log.debug("end findByCountry");
		return professionList;
	}

	public Profession findById(String professionId){
		log.debug("init findById");
		Profession profession = new Profession();
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.HUMAN_CAPITAL_PERSISTENT_REPOSITORY);
		IProfessionDao professionDao = daoFactory.getProfessionDao();
		profession = professionDao.findById( professionId);
		log.debug("end findById");
		return profession;
	}

	public boolean saveProfessionInProfileByUserId(String userId, Profession profession){
		boolean resval = false;
		log.debug("init saveProfessionInProfile");
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.HUMAN_CAPITAL_PERSISTENT_REPOSITORY);
		IProfessionDao professionDao = daoFactory.getProfessionDao();
		resval = professionDao.saveProfessionInPersonByUserId(userId, profession);
		log.debug("end saveProfessionInProfile");
		return resval;
	}

	public List<Profession> findByUserId(String userId){
		log.debug("init findByUserId");
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.HUMAN_CAPITAL_PERSISTENT_REPOSITORY);
		IProfessionDao professionDao = daoFactory.getProfessionDao();
		List<Profession> professions = professionDao.findByUserId(userId);
		log.debug("end findByUserId");
		return professions;
	}

}
