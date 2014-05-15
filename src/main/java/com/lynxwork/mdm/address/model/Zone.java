package com.lynxwork.mdm.address.model;

import java.io.Serializable;

public class Zone implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6594259708691050615L;
	private String zoneId;
	private String zone;
	
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}

}
