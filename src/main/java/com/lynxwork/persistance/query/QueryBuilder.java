package com.lynxwork.persistance.query;

import java.util.Map;
import java.util.HashMap;

public class QueryBuilder {

	private HashMap<String,String> equal;

	
	public void addEqual(String key, String value){
		equal = new HashMap<String,String>();
		equal.put(key, value);
	}
	public HashMap<String,String> getEqual(){
		return equal;
	}
	
	public void addNotEqual(String key, String value){
		
	}	

	
}
