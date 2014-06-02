package com.lynxwork.hcm.profile.dao.impl.mongo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.lynxwork.hcm.profile.dao.IProfessionDao;
import com.lynxwork.hcm.profile.model.Profession;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.lynxwork.persistance.exception.SaveEntityException;
import com.lynxwork.persistance.mongo.dml.QueryBuilder;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class ProfessionDao implements IProfessionDao{

	static final Logger log = Logger.getLogger(ProfessionDao.class);
	private static final String ENTITY_NAME ="Profession";
	private static final String ENTITY_PERSON_NAME = "Person";
	MongoDbConnection cnn;
	DB db;
	
	public ProfessionDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}
	
	
	public ObjectId save(Profession profession) throws SaveEntityException{
		  log.debug( "Save Profession Entity in Mongo DB: ");
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  ObjectId oid = new ObjectId();
		  document = getMapEntity(document, oid,profession);
		  WriteResult wr = collection.insert(document);
		  if(wr.getError()!=null){
			  String msgErr = "No fue posible salvar la entidad Person mongodb ["+wr.getError()+"]";
			  log.debug( msgErr );
			  throw new SaveEntityException(msgErr);
		  }
		  log.debug( "End Save Profession Entity in Mongo DB: ");
		  return oid;
	}
	

	@Override
	public List<Profession> findByCountry(String countryId) {
		log.debug("init findByCountry");
		List<Profession> professionList = new ArrayList<Profession>();
		//Se obtienen los datos del usuario insertado
		DBCollection findPerson = db.getCollection(ENTITY_NAME);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("countryId", countryId);
		DBCursor cursor = findPerson.find(searchQuery);
		log.debug("Cursor elements" + cursor.size()); 
		try {
			while (cursor.hasNext()) {
				BasicDBObject obj = (BasicDBObject) cursor.next();
				Profession profession = new Profession();
				profession = setMapEntity(obj,profession);
				professionList.add(profession);
			}
		} finally {
			   cursor.close();
		}
		log.debug("end findByCountry");
		return professionList;
	}

	
	/**
	 * Search profession list by professioId
	 * **/
	@Override
	public Profession findById(String professionId) {
		log.debug("init findById");
		Profession profession = new Profession();
		//Se obtienen los datos del usuario insertado
		DBCollection find = db.getCollection(ENTITY_NAME);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("professionId", professionId);
		BasicDBObject dbObject = (BasicDBObject)find.findOne(searchQuery);
		profession = setMapEntity(dbObject,profession);
		log.debug("end findById");
		return profession;
	}

	/**
	 * Search profession list by userId, this method extract the profession list from array in Person document
	 * **/
	@Override
	public List<Profession> findByUserId(String userId) {
		log.debug("init findByUserId");
		List<Profession> professionList = new ArrayList<Profession>();
		try{
		DBCollection personCollection = db.getCollection(ENTITY_PERSON_NAME);
		// Query opcions
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("userId", userId);
		// get professions list
		BasicDBObject basicDBObject = (BasicDBObject) personCollection
				.findOne(whereQuery);
		BasicDBList professions = (BasicDBList) basicDBObject
				.get("professions");
		// Reading data from Array.
		for (int i = 0; i < professions.size(); i++) {
			String professionId = (String) professions.get(i);
			log.debug("professionId:" + professionId);
			//Search the complete definition for profssion
			Profession p = findById(professionId);
			professionList.add(p);
		}
		}catch(Exception e){
			log.error("Error no profession list in profile" + e);
		}
		log.debug("end findByUserId");
		return professionList;
	}
	

	@Override
	public boolean saveProfessionInPersonByUserId(String userId,
			Profession profession) {
		boolean resval = false;
		QueryBuilder queryBuilder = new QueryBuilder();
		resval = queryBuilder.updateArrayProperty(ENTITY_PERSON_NAME, "userId",
				userId, "professions", profession.getProfessionId());
		return resval;
	}

	/**
	 * Mapea los campos de la entidad
	 * **/
	public Profession setMapEntity(BasicDBObject obj,Profession profession){
		profession.setProfessionId( obj.getString("professionId") );
		profession.setName( obj.getString("name") );
		profession.setDescription(obj.getString("description"));
		profession.setCountryId(obj.getString("countryId"));
		return profession;
	}

	/**
	 * Mapea los campos de la entidad
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,ObjectId oid,Profession profession){
		document.put("professionId", profession.getProfessionId() );
		document.put("name", profession.getName() );
		document.put("description", profession.getDescription() );
		document.put("countryId", profession.getCountryId() );
		return document;
	}

}
