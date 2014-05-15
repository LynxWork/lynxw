package com.lynxwork.mdm.address.dao.impl.mongo;

import org.apache.log4j.Logger;

import com.lynxwork.mdm.address.dao.IAddressRelationDao;
import com.lynxwork.mdm.address.model.AddressRelation;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class AddressRelationDao implements IAddressRelationDao{
	
	static final Logger log = Logger.getLogger(AddressRelationDao.class);
	private static String ENTITY_NAME ="user";
	MongoDbConnection cnn;
	DB db;


	public AddressRelationDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}

	public void save(AddressRelation addressRelation){
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  document = getMapEntity(document, addressRelation);
		  WriteResult wr = collection.insert(document);
		  log.debug( "error:" + wr.getError() );
		 }
	
	/**
	 * Busca una entidad
	 * @param adreesId AddressRelation adreesId
	 * **/
	@Override
	public AddressRelation find(String addressId) {
		AddressRelation addressRelation = new AddressRelation();
			//Se obtienen los datos del usuario insertado
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("adreesId", addressId);
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					log.debug(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
					addressRelation = setMapEntity(obj,addressRelation);
					break;
				}
			} finally {
				   cursor.close();
			}
		return addressRelation;
	}


	/**
	 * Mapea los campos de la entidad
	 *@param adreesId AddressRelation adreesId
	 * **/
	public AddressRelation setMapEntity(BasicDBObject obj,AddressRelation addressRelation){
		addressRelation.setRelationId( obj.getString("relationId") );
		addressRelation.setRelationTbl( obj.getString("relationTbl") );
		addressRelation.setAdreesId( obj.getString("adreesId") );
		return addressRelation;
	}

	/**
	 * Mapea los campos de la entidad
	 *@param adreesId AddressRelation adreesId
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,AddressRelation addressRelation){
		document.put("relationId", addressRelation.getRelationId() );
		document.put("relationTbl", addressRelation.getRelationTbl() );
		document.put("adreesId", addressRelation.getAdreesId() );
		return document;
	}
}
