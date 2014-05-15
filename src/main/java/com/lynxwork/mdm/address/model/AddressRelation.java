package com.lynxwork.mdm.address.model;

import java.io.Serializable;

public class AddressRelation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2882082144534383435L;
	private String  relationId;
	private String relationTbl;
	private String adreesId;
	
	
	
	public String getRelationTbl() {
		return relationTbl;
	}
	public void setRelationTbl(String relationTbl) {
		this.relationTbl = relationTbl;
	}
	public String getAdreesId() {
		return adreesId;
	}
	public void setAdreesId(String adreesId) {
		this.adreesId = adreesId;
	}
	public String getRelationId() {
		return relationId;
	}
	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}
}
