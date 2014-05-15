package com.lynxwork.mdm.address.dao.impl.mongo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lynxwork.mdm.address.dao.ICountryDao;
import com.lynxwork.mdm.address.model.Country;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class CountryDao implements ICountryDao  {
	
	static final Logger log = Logger.getLogger(CountryDao.class);
	private static String ENTITY_NAME ="Country";
	MongoDbConnection cnn;
	DB db;


	public CountryDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}

	public void save(Country country){
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  document = getMapEntity(document, country);
		  WriteResult wr = collection.insert(document);
		  log.debug( "error:" + wr.getError() );
		 }
	
	/**
	 * Busca una entidad
	 * @param email User email
	 * **/
	@Override
	public Country find(String name) {
		Country country = new Country();
			//Se obtienen los datos del usuario insertado
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", name);
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					BasicDBObject obj = (BasicDBObject) cursor.next();
					country = setMapEntity(obj,country);
					break;
				}
			} finally {
				   cursor.close();
			}
		return country;
	}

	
	/**
	 * This Method find a State list by country id
	 * @param String countryId
	 * **/
	@Override
	public List<Country> findAll() {
			//Se obtienen los datos del usuario insertado
		    List<Country> countryList = new ArrayList<Country>();
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					BasicDBObject obj = (BasicDBObject) cursor.next();
					Country country = new Country();
					country = setMapEntity(obj,country);
					countryList.add(country);
				}
			} finally {
				   cursor.close();
			}
		return countryList;
	}
	
	
	/**
	 * Mapea los campos de la entidad
	 * @param email User email
	 * @param password User password
	 * **/
	public Country setMapEntity(BasicDBObject obj,Country country){
		country.setCountryId( obj.getString("countryId") );
		country.setName( obj.getString("name") );
		country.setAcronym( obj.getString("acronym") );
		return country;
	}

	/**
	 * Mapea los campos de la entidad
	 * @param email User email
	 * @param password User password
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,Country country){
		document.put("countryId", country.getCountryId() );
		document.put("name", country.getName() );
		document.put("acronym", country.getAcronym() );
		
		return document;
	}
	
}
