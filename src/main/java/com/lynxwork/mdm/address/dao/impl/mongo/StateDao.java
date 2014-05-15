package com.lynxwork.mdm.address.dao.impl.mongo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lynxwork.mdm.address.dao.IStateDao;
import com.lynxwork.mdm.address.model.State;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class StateDao  implements IStateDao {
	
	static final Logger log = Logger.getLogger(StateDao.class);
	private static String ENTITY_NAME ="state";
	MongoDbConnection cnn;
	DB db;


	public StateDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}

	public void save(State state){
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  document = getMapEntity(document, state);
		  WriteResult wr = collection.insert(document);
		  log.debug( "error:" + wr.getError() );
		 }
	
	/**
	 * Busca una entidad
	 * @param email User email
	 * @param password User password
	 * **/
	@Override
	public State find(String name) {
		State state = new State();
			//Se obtienen los datos del usuario insertado
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", name);
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					BasicDBObject obj = (BasicDBObject) cursor.next();
					state = setMapEntity(obj,state);
					break;
				}
			} finally {
				   cursor.close();
			}
		return state;
	}


	/**
	 * This Method find a State list by country id
	 * @param String countryId
	 * **/
	@Override
	public List<State> findStateByCountryId(String countryId) {
			//Se obtienen los datos del usuario insertado
		    List<State> stateList = new ArrayList<State>();
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("countryId", countryId);
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					BasicDBObject obj = (BasicDBObject) cursor.next();
					State state = new State();
					state = setMapEntity(obj,state);
					stateList.add(state);
				}
			} finally {
				   cursor.close();
			}
		return stateList;
	}
	
	
	/**
	 * Mapea los campos de la entidad
	 * @param state state state
	 * **/
	public State setMapEntity(BasicDBObject obj,State state){
		state.setStateId( obj.getString("stateId") );
		state.setCode( obj.getString("code") );
		state.setName( obj.getString("name") );
		state.setCountryId( obj.getString("countryId") );
		return state;
	}

	/**
	 * Mapea los campos de la entidad
	 * @param email User email
	 * @param password User password
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,State state){
		document.put("stateId", state.getStateId() );
		document.put("code", state.getCode() );
		document.put("name", state.getName() );
		document.put("countryId", state.getCountryId() );
		return document;
	}
}
