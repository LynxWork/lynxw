package com.lynxwork.security.dao;

import com.lynxwork.security.dao.impl.mongo.MongoSecurityDaoFactory;

public abstract class SecurityDaoFactory {

	public static final int MONGODB = 1;
	
	public static SecurityDaoFactory getDAOFactory(int whichFactory) {
		    switch (whichFactory) {
		      case MONGODB:
		    	  return new MongoSecurityDaoFactory();
		      default: 
		          return null;
		    }
	}
	
	public abstract IUserDao getUserDAO();


}
