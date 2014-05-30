package com.lynxwork.social.factory;
import com.lynxwork.social.factory.impl.mongo.MongoSocialDaoFactory;
import com.lynxwork.social.publication.dao.IPublicationDao;

public abstract class SocialDaoFactory {

	public static final int MONGODB = 1;
	
	public static SocialDaoFactory getDAOFactory(int whichFactory) {
		    switch (whichFactory) {
		      case MONGODB:
		    	  return new MongoSocialDaoFactory();
		      default: 
		          return null;
		    }
	}

	public abstract IPublicationDao getPublicationDao();
	
}
