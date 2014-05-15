package com.lynxwork.config;

import java.util.Locale;

import com.lynxwork.security.dao.SecurityDaoFactory;
import com.lynxwork.hcm.factory.HcmDaoFactory;
import com.lynxwork.mdm.factory.MasterDataDaoFactory;

public class SystemConfig {
	//Configuration Locale
	public static final String LOCALE_MX = "MX";
	//Configuration languages
	public static final String COUNTRY_LANGUAGE_MX = "es";
	//Calendar and Dates Configurations
	public static final String DATE_PATTERN = "d/M/yy HH:mm";
	/*Almacen de persistencia para la base de datos de seguridad*/
	public static final int SECURITY_PERSISTENT_REPOSITORY = SecurityDaoFactory.MONGODB;
	public static final int MASTER_DATA_PERSISTENT_REPOSITORY = MasterDataDaoFactory.MONGODB;
	public static final int HUMAN_CAPITAL_PERSISTENT_REPOSITORY = HcmDaoFactory.MONGODB;
	//User Entity configuration properties
	public static final String USER_IS_ENABLED = "true";
	public static final String USER_IS_DISABLED = "false";
	public static final String USER_HAS_LOGOUT = "true";
	public static final String USER_HAS_LOGINT = "false";
	//Currency configuration
	public static final String CURRENCY_UOM = "MXNP";
	//Session configurations
	public static final String SESSION_CONFIG_USER = "SESSION_CONFIG_USER";
	//Security configurations
	public static final String USER_PASSWORD_PATTERN = "";
	public static final String USER_NAME_PATTERN = "";
	
	public static Locale getLocaleConfig(){
		 Locale locMX = new Locale(COUNTRY_LANGUAGE_MX,LOCALE_MX);//Default configuration from MExico
	     return locMX;
	}

	
	//Get security configurations
	public static String getUserPasswordPattern(){
		return USER_PASSWORD_PATTERN;
	}
	public static String getUserNamePattern(){
		return USER_NAME_PATTERN;
	}	
	
	
}
