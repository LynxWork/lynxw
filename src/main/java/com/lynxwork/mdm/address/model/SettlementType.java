package com.lynxwork.mdm.address.model;

import java.io.Serializable;

public class SettlementType implements Serializable { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 3108871611808259682L;
	private String name;
	private String settlementTypeId; 
	private String settlementType;
	
	public String getSettlementTypeId() {
		return settlementTypeId;
	}
	public void setSettlementTypeId(String settlementTypeId) {
		this.settlementTypeId = settlementTypeId;
	}
	public String getSettlementType() {
		return settlementType;
	}
	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
