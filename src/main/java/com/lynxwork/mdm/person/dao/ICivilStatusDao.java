package com.lynxwork.mdm.person.dao;

import org.bson.types.ObjectId;

import com.lynxwork.mdm.person.model.CivilStatus;
public interface ICivilStatusDao {

	 public CivilStatus find(String civilStatus);
	 
	 public CivilStatus findByCivilStatusId(String civilStatusId);

	public ObjectId save(ICivilStatusDao civilStatusDao);

}
