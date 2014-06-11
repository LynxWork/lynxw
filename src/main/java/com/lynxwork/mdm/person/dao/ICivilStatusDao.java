package com.lynxwork.mdm.person.dao;

import java.util.List;

import org.bson.types.ObjectId;

import com.lynxwork.mdm.person.model.CivilStatus;
public interface ICivilStatusDao {

	 public CivilStatus find(String civilStatus);

	public ObjectId save(ICivilStatusDao civilStatusDao);

	public List<CivilStatus> findByCountry(String countryId);

}
