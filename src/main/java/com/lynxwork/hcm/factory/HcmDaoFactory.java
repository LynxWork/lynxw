package com.lynxwork.hcm.factory;

import com.lynxwork.hcm.profile.dao.IEducationDao;
import com.lynxwork.hcm.profile.dao.IInstitutionDao;
import com.lynxwork.hcm.profile.dao.IInstitutionTypeDao;
import com.lynxwork.hcm.profile.dao.IProfessionDao;
import com.lynxwork.hcm.profile.dao.ISummaryDao;
import com.lynxwork.hcm.profile.factory.impl.mongo.MongoHcmDaoFactory;
import com.lynxwork.hcm.work.dao.IWorkCategoryDao;
import com.lynxwork.hcm.work.dao.IWorkTypeDao;
import com.lynxwork.mdm.person.dao.IBirthPlaceDao;
import com.lynxwork.mdm.person.dao.IBloodTypeDao;
import com.lynxwork.mdm.person.dao.ICivilStatusDao;
import com.lynxwork.mdm.person.dao.IGenderDao;
import com.lynxwork.mdm.product.dao.IProductDao;
import com.lynxwork.mdm.project.dao.IProjectDao;

public abstract  class HcmDaoFactory {
	public static final int MONGODB = 1;
	
	public static HcmDaoFactory getDAOFactory(int whichFactory) {
		    switch (whichFactory) {
		      case MONGODB:
		    	  return new MongoHcmDaoFactory();
		      default: 
		          return null;
		    }
	}

	public abstract IEducationDao getEducationDao();
	public abstract IInstitutionDao getInstitutionDao();
	public abstract IInstitutionTypeDao getInstitutionTypeDao();
	public abstract IProfessionDao getProfessionDao();
	public abstract ISummaryDao getSummaryDao();
	public abstract IWorkCategoryDao getWorkCategoryDao();
	public abstract IWorkTypeDao getWorkTypeDao();
	public abstract IProductDao getProductDao();
	public abstract IProjectDao getProjectDao();
    public abstract ICivilStatusDao getCivilStatusDao();
    public abstract IGenderDao getGenderDao();
    public abstract IBloodTypeDao getBloodTypeDao();
    public abstract IBirthPlaceDao getBirthPlaceDao();
		
	
		
}
