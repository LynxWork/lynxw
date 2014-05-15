package com.lynxwork.security.service;


import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.lynxwork.common.exception.ParameterException;
import com.lynxwork.config.SystemConfig;
import com.lynxwork.mdm.factory.MasterDataDaoFactory;
import com.lynxwork.mdm.person.dao.IPersonDao;
import com.lynxwork.mdm.person.model.Person;
import com.lynxwork.persistance.exception.SaveEntityException;
import com.lynxwork.security.dao.IUserDao;
import com.lynxwork.security.dao.SecurityDaoFactory;
import com.lynxwork.security.exception.UserRegistrationException;
import com.lynxwork.security.model.User;

public class UserService {

	static final Logger log = Logger.getLogger(UserService.class);
	
	public User findUser(String email, String currentsPassword) throws ParameterException{
		log.debug("findUser");
		User user = null;
		SecurityDaoFactory daoFactory = SecurityDaoFactory.getDAOFactory(SystemConfig.SECURITY_PERSISTENT_REPOSITORY);
		IUserDao userDao = daoFactory.getUserDAO();
		user = userDao.find(email, currentsPassword);
		log.debug("End findUser");
		return user;
	}
	
	public boolean registerUser(User user, Person person) throws UserRegistrationException, SaveEntityException, ParameterException{
		log.debug("User registration");
		boolean resval = false;
		//Validate if user exist
		User existUser = findUser(user.getEmail(), user.getCurrentsPassword());
		if(existUser!=null && existUser.getEnabled()!=null && existUser.getEnabled().equals(SystemConfig.USER_IS_ENABLED)){
			throw new UserRegistrationException("El usuario ya esta registrado");
		}else{
			log.debug("Insert a user data");
			
			SecurityDaoFactory daoFactory = SecurityDaoFactory.getDAOFactory(SystemConfig.SECURITY_PERSISTENT_REPOSITORY);
			IUserDao userDao = daoFactory.getUserDAO();
			ObjectId userOid = userDao.save(user);
			user.setUserId(userOid.toString());
			log.debug("userOid: " + userOid.toString() );
			//Insert user person
			log.debug("Insert person data");
			person.setUserId(userOid.toString());//Relation whit User
			MasterDataDaoFactory masterDatadaoFactory = MasterDataDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
			IPersonDao personDao = masterDatadaoFactory.getPersonDao();
			personDao.save(person);
		}
		log.debug("End User registration");
		return resval;
	}

}
