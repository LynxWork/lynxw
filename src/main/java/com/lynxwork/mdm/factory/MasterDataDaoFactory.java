package com.lynxwork.mdm.factory;

import com.lynxwork.mdm.address.dao.ICountryDao;
import com.lynxwork.mdm.address.dao.IStateDao;
import com.lynxwork.mdm.factory.impl.mongo.MongoMasterDataDaoFactory;
import com.lynxwork.mdm.person.dao.IBloodTypeDao;
import com.lynxwork.mdm.person.dao.ICivilStatusDao;
import com.lynxwork.mdm.person.dao.IGenderDao;
import com.lynxwork.mdm.person.dao.IPersonDao;
import com.lynxwork.mdm.product.dao.IProductDao;

public abstract class MasterDataDaoFactory {
	public static final int MONGODB = 1;
	
	public static MasterDataDaoFactory getDAOFactory(int whichFactory) {
		    switch (whichFactory) {
		      case MONGODB:
		    	  return new MongoMasterDataDaoFactory();
		      default: 
		          return null;
		    }
	}
	
	public abstract IPersonDao getPersonDao();

	public abstract IBloodTypeDao getBloodTypeDAO();

	public abstract ICivilStatusDao getCivilStatusDao();

	public abstract IGenderDao getGenderDao();

	//Methods for Address Objects
	public abstract ICountryDao getCountryDao();

	public abstract IStateDao getStateDao();

	public IProductDao getProductDao() {
	
		return null;
	}

}
