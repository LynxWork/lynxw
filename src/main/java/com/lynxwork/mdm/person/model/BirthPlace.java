package com.lynxwork.mdm.person.model;

import com.lynxwork.mdm.address.model.Country;
import com.lynxwork.mdm.address.model.State;

public class BirthPlace {
	private Country country;
	private State state;
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}

}
