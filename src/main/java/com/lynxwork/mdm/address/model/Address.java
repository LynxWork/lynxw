package com.lynxwork.mdm.address.model;

import java.io.Serializable;

public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4244544563139698047L;
	private String addressId;
	private String name;
	private String streetName;
	private String numberExterior;
	private String numberInterior;
	private String longitude;
	private String latitude;
	private String altitude;
	private String settlementId;
	private String addressType;
	
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addreessId) {
		this.addressId = addreessId;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getNumberExterior() {
		return numberExterior;
	}
	public void setNumberExterior(String numberExterior) {
		this.numberExterior = numberExterior;
	}
	public String getNumberInterior() {
		return numberInterior;
	}
	public void setNumberInterior(String numberInterior) {
		this.numberInterior = numberInterior;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getSettlementId() {
		return settlementId;
	}
	public void setSettlementId(String settlementId) {
		this.settlementId = settlementId;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
