package com.lynxwork.mdm.person.service;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.lynxwork.config.SystemConfig;
import com.lynxwork.mdm.factory.MasterDataDaoFactory;
import com.lynxwork.mdm.person.dao.IPersonDao;
import com.lynxwork.mdm.person.model.Person;
import com.lynxwork.persistance.exception.SaveEntityException;

public class PersonService {
	private Object userOid;
	public ObjectId savePerson(Person person) throws SaveEntityException{
		MasterDataDaoFactory masterDatadaoFactory = MasterDataDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		IPersonDao personDao = masterDatadaoFactory.getPersonDao();
		ObjectId oid = personDao.save(person);
		return oid;
	}
	
	public Person findPersonByUserId(String userId){
		Person person = new Person();
		MasterDataDaoFactory masterDatadaoFactory = MasterDataDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		IPersonDao personDao = masterDatadaoFactory.getPersonDao();
		personDao.findByUserId(userId);
		return person;
	}
	
	
	static final Logger log = Logger.getLogger(PersonService.class);
	public Boolean generalData(Person person){
	log.debug("Insert person data");
	boolean resval = false;
	person.setUserId(userOid.toString());//Relation whit User
	MasterDataDaoFactory masterDatadaoFactory = MasterDataDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
	IPersonDao personDao = masterDatadaoFactory.getPersonDao();
	try {
		personDao.save(person);
	} catch (SaveEntityException e) {
		// 
		e.printStackTrace();
	}
	return resval;
	}
}
