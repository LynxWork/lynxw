package com.lynxwork.mdm.factory.impl.mongo;

import com.lynxwork.mdm.address.dao.ICountryDao;
import com.lynxwork.mdm.address.dao.IStateDao;
import com.lynxwork.mdm.address.dao.impl.mongo.CountryDao;
import com.lynxwork.mdm.address.dao.impl.mongo.StateDao;
import com.lynxwork.mdm.factory.MasterDataDaoFactory;
import com.lynxwork.mdm.person.dao.IBloodTypeDao;
import com.lynxwork.mdm.person.dao.ICivilStatusDao;
import com.lynxwork.mdm.person.dao.IGenderDao;
import com.lynxwork.mdm.person.dao.IPersonDao;
import com.lynxwork.mdm.person.dao.impl.mongo.BloodTypeDao;
import com.lynxwork.mdm.person.dao.impl.mongo.CivilStatusDao;
import com.lynxwork.mdm.person.dao.impl.mongo.GenderDao;
import com.lynxwork.mdm.person.dao.impl.mongo.PersonDao;
import com.lynxwork.mdm.product.dao.IProductDao;
import com.lynxwork.mdm.product.dao.impl.mongo.ProductDao;

public class MongoMasterDataDaoFactory extends MasterDataDaoFactory{

	@Override
	public IPersonDao getPersonDao() {
		IPersonDao personDao = new PersonDao();
		return personDao;
	}

	@Override
	public IBloodTypeDao getBloodTypeDAO() {
		IBloodTypeDao bloodTypeDao = new BloodTypeDao();
		return bloodTypeDao;
	}
	
	@Override
	public ICivilStatusDao getCivilStatusDao() {
		ICivilStatusDao civilStatusDao = new CivilStatusDao();
		return civilStatusDao;
	}
	
	@Override
	public IGenderDao getGenderDao() {
		IGenderDao genderDao = new GenderDao();
		return genderDao;
	}

	@Override
	public ICountryDao getCountryDao() {
		ICountryDao countryDao = new CountryDao();
		return countryDao;
	}

	@Override
	public IStateDao getStateDao() {
		IStateDao stateDao = new StateDao();
		return stateDao;
	}
	@Override
	public IProductDao getProductDao(){
		IProductDao productDao = new ProductDao ();
		return productDao;
	}
	

}
