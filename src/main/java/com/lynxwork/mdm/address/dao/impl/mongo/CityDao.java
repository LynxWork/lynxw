package com.lynxwork.mdm.address.dao.impl.mongo;

import org.apache.log4j.Logger;

import com.lynxwork.mdm.address.dao.ICityDao;
import com.lynxwork.mdm.address.model.City;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class CityDao implements ICityDao{

	static final Logger log = Logger.getLogger(CityDao.class);
	private static String ENTITY_NAME ="City";
	MongoDbConnection cnn;
	DB db;


	public CityDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}

	public void save(City city){
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  document = getMapEntity(document, city);
		  WriteResult wr = collection.insert(document);
		  log.debug( "error:" + wr.getError() );
		 }
	
	/**
	 * Busca una entidad
	 * @param city city city
	 * **/
	@Override
	public City find(String name) {
		City city = new City();
			//Se obtienen los datos del usuario insertado
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", name);
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					log.debug(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
					city = setMapEntity(obj,city);
					break;
				}
			} finally {
				   cursor.close();
			}
		return city;
	}


	/**
	 * Mapea los campos de la entidad
	 * @param city city city
	 * **/
	public City setMapEntity(BasicDBObject obj,City city){
		city.setName( obj.getString("name") );
		city.setIdCity( obj.getString("idCity") );
		city.setCity( obj.getString("city") );
		
		return city;
	}

	/**
	 * Mapea los campos de la entidad
	 * @param city city city
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,City city){
		document.put("name", city.getName() );
		document.put("idCity", city.getIdCity() );
		document.put("city", city.getCity() );
		return document;
	}
}
