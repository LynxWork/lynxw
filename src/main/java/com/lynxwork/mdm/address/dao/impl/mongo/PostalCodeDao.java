package com.lynxwork.mdm.address.dao.impl.mongo;

import org.apache.log4j.Logger;

import com.lynxwork.mdm.address.dao.ICodePostalDao;
import com.lynxwork.mdm.address.model.PostalCode;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class PostalCodeDao implements ICodePostalDao {
	
	static final Logger log = Logger.getLogger(PostalCodeDao.class);
	private static String ENTITY_NAME ="user";
	MongoDbConnection cnn;
	DB db;

	public PostalCodeDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}

	public void save(PostalCode postalCode){
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  document = getMapEntity(document, postalCode);
		  WriteResult wr = collection.insert(document);
		  log.debug( "error:" + wr.getError() );
		 }
	
	/**
	 * Busca una entidad
	 * @param codePostalId codePostal codePostalId
	 * **/
	@Override
	public PostalCode find(String postalCodeId) {
		PostalCode postalCode = new PostalCode();
			//Se obtienen los datos del usuario insertado
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("codePostalId", postalCodeId);
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					log.debug(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
					postalCode = setMapEntity(obj,postalCode);
					break;
				}
			} finally {
				   cursor.close();
			}
		return postalCode;
	}


	/**
	 * Mapea los campos de la entidad
	 * @param codePostalId codePostal codePostalId
	 * **/
	public PostalCode setMapEntity(BasicDBObject obj,PostalCode postalCode){
		postalCode.setCodePostalId( obj.getString("codePostalId") );
		postalCode.setCodePostal( obj.getString("codePostal") );
		return postalCode;
	}

	/**
	 * Mapea los campos de la entidad
	 * @param codePostalId codePostal codePostalId
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,PostalCode postalCode){
		document.put("codePostalId", postalCode.getCodePostalId() );
		document.put("codePostal", postalCode.getCodePostal() );
		return document;
	}
}
