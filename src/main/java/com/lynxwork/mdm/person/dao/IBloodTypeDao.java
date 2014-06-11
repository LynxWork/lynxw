package com.lynxwork.mdm.person.dao;

import java.util.List;

import com.lynxwork.mdm.person.model.BloodType;

public interface IBloodTypeDao {

	 public BloodType find(String bloodTypeName);
	 
	 public List<BloodType> findByCountry(String countryId);

}
