package com.lynxwork.mdm.address.model;

import java.io.Serializable;

public class PostalCode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8614280703216654787L;
	private String codePostalId;
	private String codePostal;
	
	
	public String getCodePostalId() {
		return codePostalId;
	}
	public void setCodePostalId(String codePostalId) {
		this.codePostalId = codePostalId;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

}
