package com.lynxwork.mdm.address.dao;

import com.lynxwork.mdm.address.model.State;
import java.util.List;

public interface IStateDao {

	public State find(String name);

	public List<State> findStateByCountryId(String countryId);

	 

}
