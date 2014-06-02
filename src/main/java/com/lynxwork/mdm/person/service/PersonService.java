package com.lynxwork.mdm.person.service;

import org.bson.types.ObjectId;
import com.lynxwork.config.SystemConfig;
import com.lynxwork.mdm.factory.MasterDataDaoFactory;
import com.lynxwork.mdm.person.dao.IPersonDao;
import com.lynxwork.mdm.person.model.Person;
import com.lynxwork.persistance.exception.SaveEntityException;

public class PersonService {
	
	public ObjectId savePerson(Person person) throws SaveEntityException{
		MasterDataDaoFactory masterDatadaoFactory = MasterDataDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		IPersonDao personDao = masterDatadaoFactory.getPersonDao();
		ObjectId oid = personDao.save(person);
		return oid;
	}
	
	public ObjectId save(Person person) throws SaveEntityException{
		MasterDataDaoFactory masterDatadaoFactory = MasterDataDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		IPersonDao personDao = masterDatadaoFactory.getPersonDao();
		ObjectId oid = personDao.savePerson(person);
		return oid;
	}
	
	public Person findPersonByUserId(String userId){
		Person person = new Person();
		MasterDataDaoFactory masterDatadaoFactory = MasterDataDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		IPersonDao personDao = masterDatadaoFactory.getPersonDao();
		personDao.findByUserId(userId);
		return person;
	}
	
	
	public Person update(Person person){
		MasterDataDaoFactory masterDatadaoFactory = MasterDataDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		IPersonDao personDao = masterDatadaoFactory.getPersonDao();
		personDao.update(person);
		return person;
	}
	
	
}
