package com.lynxwork.mdm.address.model;

import java.io.Serializable;

public class District implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = -3513876560202411877L;
private String country;
 private String municipalityId;
 private String code;
 private String municipality;
 private String stateId;
 
 
 
public String getMunicipalityId() {
	return municipalityId;
}
public void setMunicipalityId(String municipalityId) {
	this.municipalityId = municipalityId;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getStateId() {
	return stateId;
}
public void setStateId(String stateId) {
	this.stateId = stateId;
}
public String getMunicipality() {
	return municipality;
}
public void setMunicipality(String municipality) {
	this.municipality = municipality;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
 
}
