package com.lynxwork.security.model;

import java.util.Date;

public class User {
	
	private String _id;
	private String userId;
	private String nickname;
    private String currentsPassword;
    private String passwordHint;
    private String isSystem; 
    private String enabled;
    private String hasLoggedOut;
    private String requierePasswordChange;
    private String lastCurrencyUom;
    private String lastLocale;
    private String lastTimeZone;
    private Date disabledDataTime;
    private int  successiveFailedLogins; 
    private String externalAuthId;
    private String userLdapDn;
    private Date lastUpdatedStamp; 
    private Date lastUpdatedTxStamp;
    private Date createdStamp;
    private Date createdTxStamp;
	private String email;
	private Integer ratings;
	private String isBasicProfileComplete;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCurrentsPassword() {
		return currentsPassword;
	}
	public void setCurrentsPassword(String currentsPassword) {
		this.currentsPassword = currentsPassword;
	}
	public String getPasswordHint() {
		return passwordHint;
	}
	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}
	public String getIsSystem() {
		return isSystem;
	}
	public void setIsSystem(String isSystem) {
		this.isSystem = isSystem;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getHasLoggedOut() {
		return hasLoggedOut;
	}
	public void setHasLoggedOut(String hasLoggedOut) {
		this.hasLoggedOut = hasLoggedOut;
	}
	public String getRequierePasswordChange() {
		return requierePasswordChange;
	}
	public void setRequierePasswordChange(String requierePasswordChange) {
		this.requierePasswordChange = requierePasswordChange;
	}
	public String getLastCurrencyUom() {
		return lastCurrencyUom;
	}
	public void setLastCurrencyUom(String lastCurrencyUom) {
		this.lastCurrencyUom = lastCurrencyUom;
	}
	public String getLastLocale() {
		return lastLocale;
	}
	public void setLastLocale(String lastLocale) {
		this.lastLocale = lastLocale;
	}
	public String getLastTimeZone() {
		return lastTimeZone;
	}
	public void setLastTimeZone(String lastTimeZone) {
		this.lastTimeZone = lastTimeZone;
	}
	public Date getDisabledDataTime() {
		return disabledDataTime;
	}
	public void setDisabledDataTime(Date disabledDataTime) {
		this.disabledDataTime = disabledDataTime;
	}
	public int getSuccessiveFailedLogins() {
		return successiveFailedLogins;
	}
	public void setSuccessiveFailedLogins(int successiveFailedLogins) {
		this.successiveFailedLogins = successiveFailedLogins;
	}
	public String getExternalAuthId() {
		return externalAuthId;
	}
	public void setExternalAuthId(String externalAuthId) {
		this.externalAuthId = externalAuthId;
	}
	public String getUserLdapDn() {
		return userLdapDn;
	}
	public void setUserLdapDn(String userLdapDn) {
		this.userLdapDn = userLdapDn;
	}
	public Date getLastUpdatedStamp() {
		return lastUpdatedStamp;
	}
	public void setLastUpdatedStamp(Date lastUpdatedStamp) {
		this.lastUpdatedStamp = lastUpdatedStamp;
	}
	public Date getLastUpdatedTxStamp() {
		return lastUpdatedTxStamp;
	}
	public void setLastUpdatedTxStamp(Date lastUpdatedTxStamp) {
		this.lastUpdatedTxStamp = lastUpdatedTxStamp;
	}
	public Date getCreatedStamp() {
		return createdStamp;
	}
	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}
	public Date getCreatedTxStamp() {
		return createdTxStamp;
	}
	public void setCreatedTxStamp(Date createdTxStamp) {
		this.createdTxStamp = createdTxStamp;
	}
	public Integer getRatings() {
		return ratings;
	}
	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIsBasicProfileComplete() {
		return isBasicProfileComplete;
	}
	public void setIsBasicProfileComplete(String isBasicProfileComplete) {
		this.isBasicProfileComplete = isBasicProfileComplete;
	}
	@Override
	public String toString() {
		StringBuffer strObj = new StringBuffer();
		strObj.append("_id: " + _id);
		strObj.append("userId: " + userId);
		strObj.append("/n currentsPassword: " + currentsPassword);
		strObj.append("/n passwordHint: " + passwordHint);
		strObj.append("/n isSystem: " + isSystem);
		strObj.append("/n enabled: " + enabled);
		strObj.append("/n hasLoggedOut: " + hasLoggedOut);
		strObj.append("/n requierePasswordChange: " + requierePasswordChange);
		strObj.append("/n lastCurrencyUom: " + lastCurrencyUom);
		strObj.append("/n lastLocale: " + lastLocale);
		strObj.append("/n lastTimeZone: " + lastTimeZone);
		strObj.append("/n successiveFailedLogins: " + successiveFailedLogins);
		strObj.append("/n externalAuthId: " + externalAuthId);
		strObj.append("/n userLdapDn: " + userLdapDn);
		strObj.append("/n lastUpdatedStamp: " + lastUpdatedStamp);
		strObj.append("/n lastUpdatedTxStamp: " + lastUpdatedTxStamp);
		strObj.append("/n createdStamp: " + createdStamp);
		strObj.append("/n createdTxStamp: " + createdTxStamp);
		strObj.append("/n email: " + email);
		strObj.append("/n ratings: " + ratings);
		return strObj.toString();
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
