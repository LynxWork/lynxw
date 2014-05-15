package com.lynxwork.mdm.person.dao;

import com.lynxwork.mdm.person.model.Gender;

public interface IGenderDao {

	public Gender find(int genderId, String gender);

}
