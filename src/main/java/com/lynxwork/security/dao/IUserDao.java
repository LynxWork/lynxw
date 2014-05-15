package com.lynxwork.security.dao;

import org.bson.types.ObjectId;

import com.lynxwork.common.exception.ParameterException;
import com.lynxwork.persistance.exception.SaveEntityException;
import com.lynxwork.security.model.User;

public interface IUserDao {

	public ObjectId save(User user) throws SaveEntityException;
	public User find(String email, String currentsPassword) throws ParameterException;
		
		
	
}
