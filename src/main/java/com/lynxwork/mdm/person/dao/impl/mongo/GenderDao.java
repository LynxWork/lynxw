package com.lynxwork.mdm.person.dao.impl.mongo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lynxwork.mdm.person.dao.IGenderDao;
import com.lynxwork.mdm.person.model.Gender;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;



public class GenderDao implements IGenderDao {
	
	static final Logger log = Logger.getLogger(GenderDao.class);
	private static String ENTITY_NAME ="Gender";
	MongoDbConnection cnn;
	DB db;

	public GenderDao(){
		cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}
	public void save(Gender gender){
		  boolean resval = false;
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  document = getMapEntity(document, gender);
		  WriteResult wr = collection.insert(document);
		  log.debug( "error:" + wr.getError() );
		 }
	/**
	 * Busca una entidad
	 * @param genderId Gender genderId
	 * @param gender Gender gender
	 * **/
	@Override
	public Gender find(int genderId, String gender) {
		Gender gender1 = new Gender();
			//Se obtienen los datos del usuario insertado
			DBCollection findGender = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("genderId", genderId);
			searchQuery.put("gender",gender1);
			DBCursor cursor = findGender.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					
					BasicDBObject obj = (BasicDBObject) cursor.next();
					gender1 = setMapEntity(obj,gender1);
					break;
				}
			} finally {
				   cursor.close();
			}
		return gender1;
	}

	@Override
	public List<Gender> findByCountry(String countryId){
		log.debug("init findByCountry");
		List<Gender> genderList = new ArrayList <Gender>();
		DBCollection findUser =db.getCollection(ENTITY_NAME);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("countryId", countryId);
		DBCursor cursor = findUser.find(searchQuery);
		try {
			while (cursor.hasNext()) {
				BasicDBObject obj = (BasicDBObject) cursor.next();
				Gender gender = new Gender();
				gender = setMapEntity(obj,gender);
				genderList.add(gender);
				break;
			}
		} finally {
			   cursor.close();
		}
		return genderList;
	}
	
	
	/**
	 * Mapea los campos de la entidad
	 * @param genderId Gender genderId
	 * @param gender Gender gender
	 * **/
	public Gender setMapEntity(BasicDBObject obj,Gender gender){
		gender.setGenderId( obj.getString("genderId") );
		gender.setGender( obj.getString("gender") );
		gender.setDescription( obj.getString("description") );
		gender.setObservations( obj.getString("observations") );
		return gender;
	}

	/**
	 * Mapea los campos de la entidad
	 * @param genderId Gender genderId
	 * @param gender Gender gender
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,Gender gender){
		document.put("genderId", gender.getGenderId() );
		document.put("gender", gender.getGender() );
		document.put("description", gender.getDescription() );
		document.put("observations", gender.getObservations() );
		return document;
	}
	

}
