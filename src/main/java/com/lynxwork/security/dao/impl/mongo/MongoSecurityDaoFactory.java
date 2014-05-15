package com.lynxwork.security.dao.impl.mongo;

import com.lynxwork.security.dao.IUserDao;
import com.lynxwork.security.dao.SecurityDaoFactory;

public class MongoSecurityDaoFactory extends SecurityDaoFactory{
	
	@Override
	public IUserDao getUserDAO() {
		UserDao userDao = new UserDao();
		return userDao;
	}

}
