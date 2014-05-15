package com.lynxwork.hcm.factory.impl.mongo;

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
import com.lynxwork.mdm.product.dao.IProductDao;
import com.lynxwork.mdm.product.dao.impl.mongo.ProductDao;


public abstract class MongoHcmDaoFactory extends HcmDaoFactory{

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
	public IWorkCategoryDao getWorkCategoryDao() {
		return new WorkCategoryDao();
	}

	@Override
	public IWorkTypeDao getWorkTypeDao() {
		return new WorkTypeDao();
	}
	
	@Override
	public IProductDao getProductDao() {
		return new ProductDao();
	}

}
