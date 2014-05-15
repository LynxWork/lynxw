package com.lynxwork.mdm.address.dao.impl.mongo;

import org.apache.log4j.Logger;

import com.lynxwork.mdm.address.dao.ISettlementTypeDao;
import com.lynxwork.mdm.address.model.SettlementType;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class SettlementTypeDao implements ISettlementTypeDao  {
	
	static final Logger log = Logger.getLogger(SettlementTypeDao.class);
	private static String ENTITY_NAME ="user";
	MongoDbConnection cnn;
	DB db;


	public SettlementTypeDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}

	public void save(SettlementType settlementType){
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  document = getMapEntity(document, settlementType);
		  WriteResult wr = collection.insert(document);
		  log.debug( "error:" + wr.getError() );
		 }
	
	/**
	 * Busca una entidad
	 * @param settlementType settlementType settlementType
	 * **/
	@Override
	public SettlementType find(String name) {
		SettlementType settlementType = new SettlementType();
			//Se obtienen los datos del usuario insertado
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", name);
			
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					log.debug(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
					settlementType = setMapEntity(obj,settlementType);
					break;
				}
			} finally {
				   cursor.close();
			}
		return settlementType;
	}


	/**
	 * Mapea los campos de la entidad
	 * @param settlementType settlementType settlementType 
	 * **/
	public SettlementType setMapEntity(BasicDBObject obj,SettlementType settlementType){
		settlementType.setName( obj.getString("name") );
		settlementType.setSettlementTypeId( obj.getString("settlementTypeId") );
		settlementType.setSettlementType( obj.getString("settlementType") );
		return settlementType;
	}
	/**
	 * Mapea los campos de la entidad
	 * @param email User email
	 * @param password User password
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,SettlementType settlementType){
		document.put("name", settlementType.getName() );
		document.put("settlementTypeId", settlementType.getSettlementTypeId() );
		document.put("settlementType", settlementType.getSettlementType() );
	
		return document;
	}
	

}
