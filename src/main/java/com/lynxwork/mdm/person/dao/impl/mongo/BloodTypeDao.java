package com.lynxwork.mdm.person.dao.impl.mongo;

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
		bloodType.setBloodype( obj.getString("bloodype") );
		bloodType.setDescription( obj.getString("description") );
		bloodType.setObservations( obj.getString("observations") );
		bloodType.setCreateData( obj.getDate("createData") );
		bloodType.setCreatorId( obj.getInt("creatorId") );
		bloodType.setCreatoIp( obj.getInt("creatoIp") );
		bloodType.setLastUpdateDate( obj.getString("lastUpdateDate") );
		bloodType.setLastUpdaterId( obj.getDate("lastUpdaterId") );
		bloodType.setLastUpdaterIp( obj.getString("lastUpdaterIp") );
		
		
	return bloodType;
	}

	/**
	 * Mapea los campos de la entidad
	 @param bloodype BloodTypeDao bloodype 
	  * **/
	public BasicDBObject getMapEntity(BasicDBObject document,BloodType bloodType){
		document.put("bloodTypeId", bloodType.getBloodTypeId() );
		document.put("bloodype", bloodType.getBloodype() );
		document.put("description", bloodType.getDescription() );
		document.put("observations", bloodType.getObservations() );
		document.put("createData", bloodType.getCreateData() );
		document.put("creatorId", bloodType.getCreatorId() );
		document.put("creatoIp", bloodType.getCreatoIp() );
		document.put("lastUpdaterId", bloodType.getLastUpdaterId() );
		document.put("lastUpdaterIp", bloodType.getLastUpdaterIp() );
		return document;
	}


}
