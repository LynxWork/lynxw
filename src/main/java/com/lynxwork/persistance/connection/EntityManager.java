package com.lynxwork.persistance.connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.lynxwork.metamodel.Entity;
import com.lynxwork.metamodel.Property;
import com.lynxwork.persistance.mongo.dml.QueryBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

public class EntityManager {

	MongoDbConnection cnn;
	DB db;
	static final Logger log = Logger.getLogger(EntityManager.class);
	
	public EntityManager(){
		cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();		
	}
	
	
	/**
	 * Iserta una entidad
	 * @param entityName Entity Name
	 * @param entityName Entity Name
	 * **/
	public boolean saveEntity(Entity entity){
		boolean resval = false;
		//Se inserta 
		DBCollection collection = db.getCollection(entity.getName());
		BasicDBObject document = new BasicDBObject();
		for(Property prop: entity.getProperties()){
			document.put(prop.getName(), prop.getValue());
		}
		WriteResult wr = collection.insert(document);
		System.out.println( "error:" + wr.getError() );
		return resval;
	}
	

	/**
	 * Busca una entidad
	 * @param entityName Entity Name
	 * @param entityName Entity Name
	 * **/
	public Entity findEntity(String entityName, QueryBuilder builder){
		Entity entity = new Entity();
		//Se obtienen los datos del usuario insertado
		DBCollection findUser = db.getCollection(entityName);
		BasicDBObject searchQuery = new BasicDBObject();
		
		//construccion de las sentencias equals		
		HashMap<String,String> equals = builder.getEqual();
		Iterator<Entry<String, String>> it = equals.entrySet().iterator();
		while (it.hasNext()) {
		Map.Entry<String,String> equal = (Entry<String, String>)it.next();
		log.debug(equal.getKey() + " = " + equal.getValue());
		  searchQuery.put((String)equal.getKey(), (String)equal.getValue());
		}
		    
		DBCursor cursor = findUser.find(searchQuery);
		try {
			while (cursor.hasNext()) {
				 log.debug(cursor.next());
				 BasicDBObject obj = (BasicDBObject) cursor.next();
				 
				 //Get de IOD
				 String oid = obj.getString("_id");
				 //String oid = _id. getString("$oid");
				 log.debug("**************************oid:   " + oid);
				 //53363f63d42e322de155c569
				 
				 
				 Set<String> keys =  obj.keySet();
				 List<Property> entityPropertyList = new ArrayList<Property>();
				 for(String key: keys){
					log.debug("key: " + key +"value: "+ obj.getString(key) );
				    Property property = new Property();
				    property.setName(key);
				    property.setValue(obj.getString(key));
				    entityPropertyList.add(property);
				}
				//Update property
				entity.setName(entityName);
				entity.setProperties(entityPropertyList);
				break;
			}
		} finally {
			   cursor.close();
		}
		return entity;
	}
	
	public boolean update(Object obj){
		
		return true;
	}
	
}