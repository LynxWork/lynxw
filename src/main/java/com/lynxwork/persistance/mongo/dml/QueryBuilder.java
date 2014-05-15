package com.lynxwork.persistance.mongo.dml;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.WriteResult;

public class QueryBuilder {

	static final Logger log = Logger.getLogger(QueryBuilder.class);
	
	public static final String UPDATE_COMMAND = "$set";
	MongoDbConnection cnn;
	DB db;
	
	public QueryBuilder (){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}
	
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

	/**
	 * Update a property array of Entity Document
	 * @param entityName Name of entity to be updated
	 * @param entityName Name of entity property to be updated
	 * @param searchProperty Name of entity property to be searched
	 * */
	public boolean updateArrayProperty(String entityName, String searchPropertyName, String searchPropertyValue, String updatePropertyName,String updatePropertyValue){
		boolean resval = false;
		String[] newListToUpdate = null;
		DBCollection personCollection = db.getCollection(entityName);
		//Search object to update
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put(searchPropertyName, searchPropertyValue);
		BasicDBObject basicDBObject = (BasicDBObject) personCollection.findOne(whereQuery);
		//Get the arrays values
		newListToUpdate = getArrayList(basicDBObject, updatePropertyName);
		// add the new profession to list
		int index = 0;
		if(newListToUpdate.length>0){
			index = newListToUpdate.length - 1; 
		}
		newListToUpdate[index] = updatePropertyValue;
		//Update property array
		BasicDBObject updateQuery = new BasicDBObject();
		updateQuery.append(UPDATE_COMMAND,new BasicDBObject().append(updatePropertyName, newListToUpdate));
		
		WriteResult err = personCollection.update(whereQuery, updateQuery);
		if (err == null) {
			resval = true;
		}
		return resval;
	}


	/**
	 * Get the ArrayList of itens in Basic Object
	 * */
	public String[] getArrayList(BasicDBObject object, String arrayName){
		int listSize = 0;
		String[] newList = null;
		BasicDBList dbList = (BasicDBList) object
				.get(arrayName);
		if(dbList!=null && dbList.size()>0){
			listSize = dbList.size() + 1;
			// Reading data from Array.
			log.debug("Allow items in list");
			newList = new String[listSize];
			for (int i = 0; i < dbList.size(); i++) {
				String professionString = (String) dbList.get(i);
				log.debug("item list:" + professionString);
				newList[i] = professionString;
			}
		}else{
			log.debug("Not items in profile");
			listSize = 1;
			newList = new String[listSize];
		}
		return newList;
	}
}
