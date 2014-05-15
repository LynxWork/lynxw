package com.lynxwork.mdm.address.dao;

import java.util.List;

import com.lynxwork.mdm.address.model.Country;

public interface ICountryDao {

	public Country find(String name);

	List<Country> findAll();



}
