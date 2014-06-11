package com.lynxwork.mdm.person.dao.impl.mongo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lynxwork.mdm.person.dao.IBloodTypeDao;
import com.lynxwork.mdm.person.model.BloodType;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class BloodTypeDao implements IBloodTypeDao {
	static final Logger log = Logger.getLogger(BloodTypeDao.class);
	private static String ENTITY_NAME ="BloodType";
	MongoDbConnection cnn;
	DB db;


	public BloodTypeDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}
	
	public void save(BloodType bloodType){
		  boolean resval = false;
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  document = getMapEntity(document, bloodType);
		  WriteResult wr = collection.insert(document);
		  log.debug( "error:" + wr.getError() );
		 }
	public List<BloodType> findByCountry(String countryId){
		log.debug("init findByCountry");
		List<BloodType> bloodTypeList = new ArrayList <BloodType>();
		DBCollection findUser =db.getCollection(ENTITY_NAME);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("countryId", countryId);
		DBCursor cursor = findUser.find(searchQuery);
		try {
			while (cursor.hasNext()) {
				BasicDBObject obj = (BasicDBObject) cursor.next();
				BloodType bloodType = new BloodType();
				bloodType = setMapEntity(obj,bloodType);
				bloodTypeList.add(bloodType);
				break;
			}
		} finally {
			   cursor.close();
		}
		return bloodTypeList;
	}
	

	/**
	 * Busca una entidad
	 * @param email User email
	 * @param password User password
	 * **/
	@Override
	public BloodType find(String bloodTypeName) {
			BloodType bloodType = new BloodType();
			//Se obtienen los datos del usuario insertado
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("bloodType", bloodTypeName);
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					log.debug(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
					bloodType = setMapEntity(obj,bloodType);
					break;
				}
			} finally {
				   cursor.close();
			}
		return bloodType;
	}

	
	/**
	 * Mapea los campos de la entidad
	 * @param bloodype BloodTypeDao bloodype 
	 * **/
	public BloodType setMapEntity(BasicDBObject obj,BloodType bloodType){
		bloodType.setBloodTypeId( obj.getString("bloodTypeId") );
		bloodType.setBloodType( obj.getString("bloodType") );
		bloodType.setDescription( obj.getString("description") );
		bloodType.setObservations( obj.getString("observations") );
		bloodType.setCreateData( obj.getString("createData") );
		bloodType.setCreatorId( obj.getString("creatorId") );
		bloodType.setCreatoIp( obj.getString("creatoIp") );
		bloodType.setLastUpdateDate( obj.getString("lastUpdateDate") );
		bloodType.setLastUpdaterId( obj.getString("lastUpdaterId") );
		bloodType.setLastUpdaterIp( obj.getString("lastUpdaterIp") );
		bloodType.setCountryId( obj.getString("countryId") );
		
	return bloodType;
	}

	/**
	 * Mapea los campos de la entidad
	 @param bloodype BloodTypeDao bloodype 
	  * **/
	public BasicDBObject getMapEntity(BasicDBObject document,BloodType bloodType){
		document.put("bloodTypeId", bloodType.getBloodTypeId() );
		document.put("bloodType", bloodType.getBloodType() );
		document.put("description", bloodType.getDescription() );
		document.put("observations", bloodType.getObservations() );
		document.put("createData", bloodType.getCreateData() );
		document.put("creatorId", bloodType.getCreatorId() );
		document.put("creatoIp", bloodType.getCreatoIp() );
		document.put("lastUpdaterId", bloodType.getLastUpdaterId() );
		document.put("lastUpdaterIp", bloodType.getLastUpdaterIp() );
		document.put("countryId", bloodType.getCountryId() );
		return document;
	}


}
