package com.lynxwork.hcm.profile.factory.impl.mongo;

import com.lynxwork.hcm.factory.HcmDaoFactory;
import com.lynxwork.hcm.profile.dao.IEducationDao;
import com.lynxwork.hcm.profile.dao.IInstitutionDao;
import com.lynxwork.hcm.profile.dao.IInstitutionTypeDao;
import com.lynxwork.hcm.profile.dao.IProfessionDao;
import com.lynxwork.hcm.profile.dao.ISummaryDao;
import com.lynxwork.hcm.profile.dao.impl.mongo.EducationDao;
import com.lynxwork.hcm.profile.dao.impl.mongo.InstitutionDao;
import com.lynxwork.hcm.profile.dao.impl.mongo.InstitutionTypeDao;
import com.lynxwork.hcm.profile.dao.impl.mongo.ProfessionDao;
import com.lynxwork.hcm.profile.dao.impl.mongo.SummaryDao;
import com.lynxwork.hcm.work.dao.IWorkCategoryDao;
import com.lynxwork.hcm.work.dao.IWorkTypeDao;
import com.lynxwork.hcm.work.dao.impl.mongo.WorkCategoryDao;
import com.lynxwork.hcm.work.dao.impl.mongo.WorkTypeDao;
import com.lynxwork.mdm.person.dao.IBirthPlaceDao;
import com.lynxwork.mdm.person.dao.IBloodTypeDao;
import com.lynxwork.mdm.person.dao.ICivilStatusDao;
import com.lynxwork.mdm.person.dao.IGenderDao;
import com.lynxwork.mdm.person.dao.impl.mongo.BirthPlaceDao;
import com.lynxwork.mdm.person.dao.impl.mongo.BloodTypeDao;
import com.lynxwork.mdm.person.dao.impl.mongo.CivilStatusDao;
import com.lynxwork.mdm.person.dao.impl.mongo.GenderDao;
import com.lynxwork.mdm.product.dao.IProductDao;
import com.lynxwork.mdm.product.dao.impl.mongo.ProductDao;
import com.lynxwork.mdm.project.dao.IProjectDao;
import com.lynxwork.mdm.project.dao.impl.mongo.ProjectDao;


public class MongoHcmDaoFactory extends HcmDaoFactory{

	@Override
	public IEducationDao getEducationDao() {
		return new EducationDao();
	}

	@Override
	public IInstitutionDao getInstitutionDao() {
		return new InstitutionDao();
	}

	@Override
	public IInstitutionTypeDao getInstitutionTypeDao() {
		return new InstitutionTypeDao();
	}

	@Override
	public IProfessionDao getProfessionDao() {
		return new ProfessionDao();
	}

	@Override
	public ISummaryDao getSummaryDao() {
		return new SummaryDao();
	}
	
	@Override
	public IProductDao getProductDao() {
		return new ProductDao();
	}

	@Override
	public IWorkCategoryDao getWorkCategoryDao() {
		return new WorkCategoryDao();
	}

	@Override
	public IWorkTypeDao getWorkTypeDao() {
		return new WorkTypeDao();
	}

	@Override
	public IProjectDao getProjectDao() {
		return new ProjectDao();
	}

	@Override
	public ICivilStatusDao getCivilStatusDao() {
		return new CivilStatusDao();
	}
	@Override
	 public IGenderDao getGenderDao(){
	return new GenderDao();
	}

	@Override
	public IBloodTypeDao getBloodTypeDao() {
		return new BloodTypeDao() ;
	}

	@Override
	public IBirthPlaceDao getBirthPlaceDao() {
		return new BirthPlaceDao();
	}
}