package com.lynxwork.mdm.address.model;

import java.io.Serializable;

public class Settlement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1626680771381717706L;
	private String name;
	private String settlementId;
	private String settlement;
	private String cityId;
	private String codePostalId;
	private String stateId;
	private int municipality;
	private String settlementTypeId;
	private String zoneId;
	
	public String getSettlementId() {
		return settlementId;
	}
	public void setSettlementId(String settlementId) {
		this.settlementId = settlementId;
	}
	public String getSettlement() {
		return settlement;
	}
	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCodePostalId() {
		return codePostalId;
	}
	public void setCodePostalId(String codePostalId) {
		this.codePostalId = codePostalId;
	}
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	public int getMunicipality() {
		return municipality;
	}
	public void setMunicipality(int municipality) {
		this.municipality = municipality;
	}
	public String getSettlementTypeId() {
		return settlementTypeId;
	}
	public void setSettlementTypeId(String settlementTypeId) {
		this.settlementTypeId = settlementTypeId;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
