package com.lynxwork.mdm.address.dao.impl.mongo;

import org.apache.log4j.Logger;

import com.lynxwork.mdm.address.dao.ISettlementDao;
import com.lynxwork.mdm.address.model.Settlement;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class SettlementDao implements ISettlementDao{
	
	static final Logger log = Logger.getLogger(SettlementDao.class);
	private static String ENTITY_NAME ="settlement";
	MongoDbConnection cnn;
	DB db;


	public SettlementDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}

	public void save(Settlement settlement){
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  document = getMapEntity(document, settlement);
		  WriteResult wr = collection.insert(document);
		  log.debug( "error:" + wr.getError() );
		 }
	
	/**
	 * Busca una entidad
	 * @param settlement settlement settlement
	 * **/
	@Override
	public Settlement find(String name) {
		Settlement settlement= new Settlement();
			//Se obtienen los datos del usuario insertado
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", name);
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					log.debug(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
					settlement = setMapEntity(obj,settlement);
					break;
				}
			} finally {
				   cursor.close();
			}
		return settlement;
	}


	/**
	 * Mapea los campos de la entidad
	 * @param settlement settlement settlement
	 * **/
	public Settlement setMapEntity(BasicDBObject obj,Settlement settlement){
		settlement.setName( obj.getString("name") );
		settlement.setSettlementId( obj.getString("settlementId") );
		settlement.setSettlement( obj.getString("settlement") );
		settlement.setCityId( obj.getString("cityId") );
		settlement.setCodePostalId( obj.getString("codePostalId") );
		settlement.setStateId( obj.getString("stateId") );
		settlement.setMunicipality( obj.getInt("municipality") );
		settlement.setSettlementTypeId( obj.getString("settlementTypeId") );
		settlement.setZoneId( obj.getString("zoneId") );
		return settlement;
	}

	/**
	 * Mapea los campos de la entidad
	 * @param email User email
	 * @param password User password
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,Settlement settlement){
		document.put("name", settlement.getName() );
		document.put("settlementId", settlement.getSettlementId() );
		document.put("settlement", settlement.getSettlement() );
		document.put("cityId", settlement.getCityId() );
		document.put("codePostalId", settlement.getCodePostalId() );
		document.put("stateId", settlement.getStateId() );
		document.put("municipality", settlement.getMunicipality());
		document.put("zoneId", settlement.getZoneId() );
		return document;
	}

}
