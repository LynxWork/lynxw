package com.lynxwork.mdm.address.dao.impl.mongo;

import org.apache.log4j.Logger;

import com.lynxwork.mdm.address.dao.IAddressTypeDao;
import com.lynxwork.mdm.address.model.AddressType;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class AddressTypeDao implements IAddressTypeDao {
	static final Logger log = Logger.getLogger(AddressTypeDao.class);
	private static String ENTITY_NAME ="user";
	MongoDbConnection cnn;
	DB db;


	public AddressTypeDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}

	public void save(AddressType addressType){
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  document = getMapEntity(document, addressType);
		  WriteResult wr = collection.insert(document);
		  log.debug( "error:" + wr.getError() );
		 }
	
	/**
	 * Busca una entidad
	 * @param addreessType addreessType addreessType
	 * **/
	@Override
	public AddressType find(String name) {
		AddressType addreessType = new AddressType();
			//Se obtienen los datos del usuario insertado
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", name);
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					log.debug(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
					addreessType = setMapEntity(obj,addreessType);
					break;
				}
			} finally {
				   cursor.close();
			}
		return addreessType;
	}


	/**
	 * Mapea los campos de la entidad
	 * @param addreessType addreessType addreessType
	 * **/
	public AddressType setMapEntity(BasicDBObject obj,AddressType addressType){
		addressType.setName( obj.getString("name") );
		addressType.setAddreessTypeId( obj.getString("addreessTypeId") );
		addressType.setAddreessType( obj.getString("addreessType") );
		addressType.setDescription( obj.getString("description") );
		addressType.setObservations( obj.getString("observations") );
		return addressType;
	}

	/**
	 * Mapea los campos de la entidad
	 * @param email User email
	 * @param password User password
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,AddressType addressType){
		document.put("name", addressType.getName() );
		document.put("addreessTypeId", addressType.getAddreessTypeId() );
		document.put("addreessType", addressType.getAddreessType() );
		document.put("description", addressType.getDescription() );
		document.put("observations", addressType.getObservations() );
		return document;
	}

}
