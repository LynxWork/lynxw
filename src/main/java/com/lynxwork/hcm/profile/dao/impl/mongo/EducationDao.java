package com.lynxwork.hcm.profile.dao.impl.mongo;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.lynxwork.hcm.profile.model.Education;
import com.lynxwork.hcm.profile.dao.IEducationDao;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.lynxwork.persistance.exception.SaveEntityException;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class EducationDao implements IEducationDao {
	static final Logger log = Logger.getLogger(EducationDao.class);
	private static String ENTITY_NAME ="Person";
	MongoDbConnection cnn;
	DB db;

	public EducationDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}
	
	public ObjectId save(Education education) throws SaveEntityException{
		  log.debug( "Save Person Entity in Mongo DB: ");
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  ObjectId oid = new ObjectId();
		  document = getMapEntity(document, oid,education);
		  WriteResult wr = collection.insert(document);
		  if(wr.getError()!=null){
			  String msgErr = "No fue posible salvar la entidad Person mongodb ["+wr.getError()+"]";
			  log.debug( msgErr );
			  throw new SaveEntityException(msgErr);
		  }
		  log.debug( "End Save Person Entity in Mongo DB: ");
		  return oid;
	}

	/**
	 * Busca una entidad
	
	 * **/
	public Education find(String country ) {
		Education education = new Education();
			//Se obtienen los datos del usuario insertado
			DBCollection findPerson = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("country", country);
			DBCursor cursor = findPerson.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					log.debug(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
					education = setMapEntity(obj,education);
					break;
				}
			} finally {
				   cursor.close();
			}
		return education;
	}


	/**
	 * Mapea los campos de la entidad
	 * @param firsName   Person firsName
	 * **/
	public Education setMapEntity(BasicDBObject obj,Education education){
		
		education.setEducationId(obj.getString("educationId"));
		education.setCountry(obj.getString("country"));
		education.setDegree(obj.getInt("degree"));
		education.setCountryId(obj.getString("countryId"));
		education.setProfileId(obj.getString("profileId"));
	
		return education;
	}

	/**
	 * Mapea los campos de la entidad
	 * @param firsName   Person firsName
	 * @param middleName Person middleName
	 * @param lastName  Person lastName
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,ObjectId oid,Education education){

		document.put("educationId", education.getEducationId() );
		document.put("country", education.getCountry() );
		document.put("degree",education.getDegree() );
		document.put("countryId",education.getCountryId() );
		document.put("profileId",education.getProfileId() );
	
		return document;
	}

	@Override
	public List<Education> findByCountry(String country) {
		return null;
	}

	@Override
	public Education findById(String educationId) {
		return null;
	}

}
