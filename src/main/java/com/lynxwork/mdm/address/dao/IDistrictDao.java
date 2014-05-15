package com.lynxwork.mdm.address.dao;

import com.lynxwork.mdm.address.model.District;

public interface IDistrictDao {

	 public District find(String country, String municipality);

}
