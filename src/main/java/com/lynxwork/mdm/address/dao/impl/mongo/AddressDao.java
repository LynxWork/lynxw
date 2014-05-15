package com.lynxwork.mdm.address.dao.impl.mongo;

import org.apache.log4j.Logger;

import com.lynxwork.mdm.address.dao.IAddressDao;
import com.lynxwork.mdm.address.model.Address;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class AddressDao implements IAddressDao {
	
	static final Logger log = Logger.getLogger(AddressDao.class);
	private static String ENTITY_NAME ="addreess";
	MongoDbConnection cnn;
	DB db;


	public AddressDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}

	public void save(Address addreess){
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  document = getMapEntity(document, addreess);
		  WriteResult wr = collection.insert(document);
		  log.debug( "error:" + wr.getError() );
		 }
	
	/**
	 * Busca una entidad
	 * @param addreess addreess addreess
	 * **/
	@Override
	public Address find(String name) {
		Address address = new Address();
			//Se obtienen los datos del usuario insertado
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", name);
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					log.debug(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
					address = setMapEntity(obj,address);
					break;
				}
			} finally {
				   cursor.close();
			}
		return address;
	}


	/**
	 * Mapea los campos de la entidad
	 * @param addreess addreess addreess
	 * **/
	public Address setMapEntity(BasicDBObject obj,Address address){
		
		address.setName( obj.getString("name") );
		address.setAddressId( obj.getString("addressId") );
		address.setStreetName( obj.getString("streetName") );
		address.setNumberExterior( obj.getString("numberExterior") );
		address.setNumberInterior( obj.getString("numberInterior") );
		address.setLongitude( obj.getString("longitude") );
		address.setLatitude( obj.getString("latitude") );
		address.setAltitude( obj.getString("altitude") );
		address.setSettlementId( obj.getString("settlementId") );
		address.setAddressType( obj.getString("addressType") );
		return address;
	}

	/**
	 * Mapea los campos de la entidad
	 * @param address address address
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,Address address){
		document.put("name", address.getName() );
		document.put("addressId", address.getAddressId() );
		document.put("streetName", address.getStreetName() );
		document.put("numberExterior", address.getNumberExterior() );
		document.put("numberInterior", address.getNumberInterior() );
		document.put("longitude", address.getLongitude() );
		document.put("latitude", address.getLatitude() );
		document.put("settlementId", address.getSettlementId() );
		document.put("addressType", address.getAddressType() );
		return document;
	}
}
