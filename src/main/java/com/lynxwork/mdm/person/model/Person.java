package com.lynxwork.mdm.person.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.lynxwork.hcm.profile.model.Profession;

public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1788404604715176938L;
	
	private String personId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String nin;//National Identified Id
	private String isNinVisible; //Indicate if nin is visible
	private String taxid;
	private String isTaxVisible; //Indicate if nin is visible
	private String ssn;
	private String isSsnVisible; //Indicate if nin is visible
	private Date birthday;
	private String stateCivilId; 
	private String isStateCivilVisible; //Indicate if nin is visible
	private String genderId;
	private String birthPlaceId;
	private String bloodTypeId;
	private String userId;
	private List <Profession> profession; 

	//Birth Place Object
	private BirthPlace birthPlace;
	private String isBirthPlace; //Indicate if birthPlace is visible
	
	public String getPersonId() 
	{
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNin() {
		return nin;
	}
	public void setNin(String nin) {
		this.nin = nin;
	}
	public String getTaxid() {
		return taxid;
	}
	public void setTaxid(String taxid) {
		this.taxid = taxid;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getStateCivilId() {
		return stateCivilId;
	}
	public void setStateCivilId(String stateCivilId) {
		this.stateCivilId = stateCivilId;
	}
	public String getGenderId() {
		return genderId;
	}
	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}
	public String getBirthPlaceId() {
		return birthPlaceId;
	}
	public void setBirthPlaceId(String birthPlaceId) {
		this.birthPlaceId = birthPlaceId;
	}
	public String getBloodTypeId() {
		return bloodTypeId;
	}
	public void setBloodTypeId(String bloodTypeId) {
		this.bloodTypeId = bloodTypeId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List <Profession> getProfession() {
		return profession;
	}
	public void setProfession(List <Profession> profession) {
		this.profession = profession;
	}
	public String getIsNinVisible() {
		return isNinVisible;
	}
	public void setIsNinVisible(String isNinVisible) {
		this.isNinVisible = isNinVisible;
	}
	public String getIsTaxVisible() {
		return isTaxVisible;
	}
	public void setIsTaxVisible(String isTaxVisible) {
		this.isTaxVisible = isTaxVisible;
	}
	public String getIsSsnVisible() {
		return isSsnVisible;
	}
	public void setIsSsnVisible(String isSsnVisible) {
		this.isSsnVisible = isSsnVisible;
	}
	public String getIsStateCivilVisible() {
		return isStateCivilVisible;
	}
	public void setIsStateCivilVisible(String isStateCivilVisible) {
		this.isStateCivilVisible = isStateCivilVisible;
	}
	public BirthPlace getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(BirthPlace birthPlace) {
		this.birthPlace = birthPlace;
	}
	public String getIsBirthPlace() {
		return isBirthPlace;
	}
	public void setIsBirthPlace(String isBirthPlace) {
		this.isBirthPlace = isBirthPlace;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("personId: " + personId);
		str.append("firstName: " + firstName);
		str.append("middleName: " + middleName);
		str.append("lastName: " + lastName);
		str.append("nin: " + nin);
		str.append("isNinVisible: " + isNinVisible);
		str.append("taxid: " + taxid);
		str.append("isTaxVisible: " + isTaxVisible);
		str.append("ssn: " + ssn);
		str.append("isSsnVisible: " + isSsnVisible);
		str.append("birthday: " + birthday);
		str.append("stateCivilId: " + stateCivilId);
		str.append("isStateCivilVisible: " + isStateCivilVisible);
		str.append("genderId: " + genderId);
		str.append("birthPlaceId: " + birthPlaceId);
		str.append("bloodTypeId: " + bloodTypeId);
		str.append("userId: " + userId);
		return str.toString();
	}
}
