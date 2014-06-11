package com.lynxwork.mdm.person.dao;

import java.util.List;

import com.lynxwork.mdm.person.model.Gender;

public interface IGenderDao {

	public Gender find(int genderId, String gender);

	public List<Gender> findByCountry(String countryId);

}
