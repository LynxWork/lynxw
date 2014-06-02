package com.lynxwork.mdm.person.dao.impl.mongo;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.lynxwork.mdm.person.dao.ICivilStatusDao;
import com.lynxwork.mdm.person.model.CivilStatus;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class CivilStatusDao implements ICivilStatusDao {
	static final Logger log = Logger.getLogger(CivilStatusDao.class);
	private static String ENTITY_NAME ="CivilStatus";
	MongoDbConnection cnn;
	DB db;


	public CivilStatusDao(){
		cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}
	
	/**
	 * Busca una entidad
	 * @param email User email
	 * @param password User password
	 * **/
	@Override
	public CivilStatus find(String civilStatus) {
		CivilStatus civil = new CivilStatus();
			//Se obtienen los datos del usuario insertado
			DBCollection findUser =db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("civilStatus", civil);
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					log.debug(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
					civil= setMapEntity(obj,civil);
					break;
				}
			} finally {
				   cursor.close();
			}
		return civil;
	}

	
	/**
	 * Mapea los campos de la entidad
	 * @param 
	 * @param 
	 * **/
	public CivilStatus setMapEntity(BasicDBObject obj,CivilStatus civil){
		civil.setCivilStatusId( obj.getString("civilStatusId") );
		civil.setCivilStatus( obj.getString("civilStatus") );
		civil.setDescriptions( obj.getString("descriptions") );
		civil.setObservations( obj.getString("observations") );
		civil.setCreateDate( obj.getString("createDate") );
		civil.setCountryId( obj.getString("countryId") );
		civil.setCreatorId( obj.getString("creatorId") );
		civil.setCreatorIp( obj.getString("creatorIp") );
		civil.setLastUpdateDate( obj.getDate("lastUpdateDate") );
		civil.setLastUpdaterId( obj.getString("lastUpdaterId") );
		civil.setLastUpdaterIp( obj.getString("lastUpdaterIp") );
		return civil;
	}

	/**
	 * Mapea los campos de la entidad
	 * @param email User email
	 * @param password User password
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,CivilStatus civil){
		document.put("civilStatusId", civil.getCivilStatusId() );
		document.put("civilStatus", civil.getCivilStatus() );
		document.put("descriptions", civil.getDescriptions() );
		document.put("createDate", civil.getCreateDate() );
		document.put("countryId", civil.getCountryId() );
		document.put("creatorId", civil.getCreatorId() );
		document.put("creatorIp", civil.getCreatorIp() );
		document.put("lastUpdateDate", civil.getLastUpdateDate() );
		document.put("lastUpdaterId", civil.getLastUpdaterId() );
		document.put("lastUpdaterIp", civil.getLastUpdaterIp() );
		
		return document;
	}

	@Override
	public CivilStatus findByCivilStatusId(String civilStatusId) {
		return null;
	}

	@Override
	public ObjectId save(ICivilStatusDao civilStatusDao) {
		return null;
	}


}
