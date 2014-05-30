package com.lynxwork.social.factory.impl.mongo;

import com.lynxwork.social.factory.SocialDaoFactory;
import com.lynxwork.social.publication.dao.IPublicationDao;
import com.lynxwork.social.publication.dao.impl.mongo.PublicationDao;

public  class MongoSocialDaoFactory extends SocialDaoFactory{

	@Override
	public IPublicationDao getPublicationDao() {
		return new PublicationDao();
	}

}
