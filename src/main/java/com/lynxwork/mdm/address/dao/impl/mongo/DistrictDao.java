package com.lynxwork.mdm.address.dao.impl.mongo;

import org.apache.log4j.Logger;

import com.lynxwork.mdm.address.dao.IDistrictDao;
import com.lynxwork.mdm.address.model.District;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class DistrictDao implements IDistrictDao{
	
	static final Logger log = Logger.getLogger(DistrictDao.class);
	private static String ENTITY_NAME ="district";
	MongoDbConnection cnn;
	DB db;


	public DistrictDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}

	public void save(District district){
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  document = getMapEntity(document, district);
		  WriteResult wr = collection.insert(document);
		  log.debug( "error:" + wr.getError() );
		 }
	
	/**
	 * Busca una entidad
	 * @param email User email
	 * @param password User password
	 * **/
	@Override
	public District find(String country, String municipality) {
		District district = new  District();
			//Se obtienen los datos del usuario insertado
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("country", country);
			searchQuery.put("municipality",municipality);
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					log.debug(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
					district = setMapEntity(obj,district);
					break;
				}
			} finally {
				   cursor.close();
			}
		return district;
	}


	/**
	 * Mapea los campos de la entidad
	 * @param email User email
	 * @param password User password
	 * **/
	public District setMapEntity(BasicDBObject obj,District district){
		district.setCountry( obj.getString("country") );
		district.setMunicipalityId( obj.getString("municipalityId") );
		district.setCode( obj.getString("code") );
		district.setMunicipality( obj.getString("municipality") );
		district.setStateId( obj.getString("stateId") );
		return district;
	}

	/**
	 * Mapea los campos de la entidad
	 * @param email User email
	 * @param password User password
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,District district){
		document.put("country", district.getCountry() );
		document.put("municipalityId", district.getMunicipalityId() );
		document.put("code", district.getCode() );
		document.put("municipality", district.getMunicipality() );
		document.put("stateId", district.getStateId() );
		return document;
	}

}
