package com.lynxwork.mdm.person.dao;

import org.bson.types.ObjectId;

import com.lynxwork.mdm.person.model.Person;
import com.lynxwork.persistance.exception.SaveEntityException;

public interface IPersonDao {

	public Person find(String firsName, String middleName, String lastName);
	
	public ObjectId save(Person person)  throws SaveEntityException;

	public Person findByUserId(String userId);

}
