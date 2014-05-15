package com.lynxwork.hcm.profile.dao;

import java.util.List;

import com.lynxwork.hcm.profile.model.Profession;

public interface IProfessionDao {

	public List<Profession> findByCountry(String countryId);

	public Profession findById(String professionId);
	
	public boolean saveProfessionInPersonByUserId(String userId, Profession profession);

	public List<Profession> findByUserId(String userId);
	
}
