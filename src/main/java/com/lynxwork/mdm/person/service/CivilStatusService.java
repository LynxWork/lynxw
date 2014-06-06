package com.lynxwork.mdm.person.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import com.lynxwork.config.SystemConfig;
import com.lynxwork.hcm.factory.HcmDaoFactory;
import com.lynxwork.mdm.factory.MasterDataDaoFactory;
import com.lynxwork.mdm.person.dao.ICivilStatusDao;
import com.lynxwork.mdm.person.model.CivilStatus;
import com.lynxwork.persistance.exception.SaveEntityException;


public class CivilStatusService {
	static final Logger log = Logger.getLogger(CivilStatusService.class);
	
	public ObjectId saveCivilStatus(CivilStatus CivilStatus) throws SaveEntityException{
		MasterDataDaoFactory masterDatadaoFactory = MasterDataDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		ICivilStatusDao CivilStatusDao = masterDatadaoFactory.getCivilStatusDao();
		ObjectId oid = CivilStatusDao.save(CivilStatusDao);
		return oid;
	}
	
	public CivilStatus findByCivilStatusId(String civilStatusId){
		CivilStatus civilStatus = new CivilStatus();
		MasterDataDaoFactory masterDatadaoFactory = MasterDataDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		ICivilStatusDao civilStatusDao = masterDatadaoFactory.getCivilStatusDao();
		civilStatusDao.findByCivilStatusId(civilStatusId);
		return civilStatus;
	}
	
	public List<CivilStatus> findByCountry(String civilStatusId){
		log.debug("init findByCountry");
		List<CivilStatus> civilStatusList = new ArrayList<CivilStatus>();
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.HUMAN_CAPITAL_PERSISTENT_REPOSITORY);
		ICivilStatusDao civilStatusDao = daoFactory.getCivilStatusDao();
		civilStatusList = civilStatusDao.findByCivilStatusId(civilStatusId);
		log.debug("end findByCountry");
		return civilStatusList;
	}
	

}
