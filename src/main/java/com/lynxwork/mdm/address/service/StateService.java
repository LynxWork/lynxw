package com.lynxwork.mdm.address.service;

import java.util.List;

import com.lynxwork.config.SystemConfig;
import com.lynxwork.mdm.address.dao.IStateDao;
import com.lynxwork.mdm.address.model.State;
import com.lynxwork.mdm.factory.MasterDataDaoFactory;

public class StateService {

	public List<State> findByCountryId(String countryId){
		MasterDataDaoFactory masterDatadaoFactory = MasterDataDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		IStateDao dao = masterDatadaoFactory.getStateDao();
		List<State> list = dao.findStateByCountryId(countryId);
		return list;
	}

}
