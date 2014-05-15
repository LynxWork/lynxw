package com.lynxwork.mdm.address.dao.impl.mongo;

import org.apache.log4j.Logger;

import com.lynxwork.mdm.address.dao.IZoneDao;
import com.lynxwork.mdm.address.model.Zone;
import com.lynxwork.persistance.connection.MongoDbConnection;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class ZoneDao implements IZoneDao{
	
	static final Logger log = Logger.getLogger(ZoneDao.class);
	private static String ENTITY_NAME ="user";
	MongoDbConnection cnn;
	DB db;


	public ZoneDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}

	public void save(Zone zone){
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  document = getMapEntity(document, zone);
		  WriteResult wr = collection.insert(document);
		  log.debug( "error:" + wr.getError() );
		 }
	
	/**
	 * Busca una entidad
	 * @param email User email
	 * @param password User password
	 * **/
	@Override
	public Zone find(String zoneId) {
		Zone zone = new Zone();
			//Se obtienen los datos del usuario insertado
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("zoneId", zoneId);
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					log.debug(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
					zone = setMapEntity(obj,zone);
					break;
				}
			} finally {
				   cursor.close();
			}
		return zone;
	}


	/**
	 * Mapea los campos de la entidad
	 * @param zoneId Zone zoneId
	 * **/
	public Zone setMapEntity(BasicDBObject obj,Zone zone){
		zone.setZoneId( obj.getString("zoneId") );
		zone.setZone( obj.getString("zone") );
		return zone;
	}

	/**
	 * Mapea los campos de la entidad
	 * @param email User email
	 * @param password User password
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,Zone zone){
		document.put("zoneId", zone.getZoneId() );
		document.put("zone", zone.getZone() );
		
		return document;
	}

}
