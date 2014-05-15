package com.lynxwork.hcm.profile.dao.impl.mongo;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.lynxwork.hcm.profile.model.Institution;
import com.lynxwork.hcm.profile.dao.IInstitutionDao;
import com.lynxwork.mdm.person.dao.impl.mongo.PersonDao;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.lynxwork.persistance.exception.SaveEntityException;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class InstitutionDao implements IInstitutionDao{
	static final Logger log = Logger.getLogger(PersonDao.class);
	private static String ENTITY_NAME ="Person";
	MongoDbConnection cnn;
	DB db;

	public InstitutionDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}
	
	public ObjectId save(Institution institution) throws SaveEntityException{
		  log.debug( "Save Person Entity in Mongo DB: ");
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  ObjectId oid = new ObjectId();
		  document = getMapEntity(document, oid,institution);
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
	 * @param firsName   Person firsName
	 * @param middleName Person middleName
	 * @param lastName  Person lastName
	 * **/
	@Override
	public Institution find(String university) {
		Institution institution = new Institution();
			//Se obtienen los datos del usuario insertado
			DBCollection findPerson = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("university", university);
			
			DBCursor cursor = findPerson.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					log.debug(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
					institution = setMapEntity(obj,institution);
					break;
				}
			} finally {
				   cursor.close();
			}
		return institution;
	}


	/**
	 * Mapea los campos de la entidad
	 * @param firsName   Person firsName
	 * @param middleName Person middleName
	 * @param lastName  Person lastName
	 * **/
	public Institution setMapEntity(BasicDBObject obj,Institution institution){
		
		institution.setInstitution(obj.getString("institution"));
		institution.setUniversity(obj.getString("university"));
		institution.setUniversity(obj.getString("institutionTypeId"));
		return institution;
	}

	/**
	 * Mapea los campos de la entidad
	 * @param firsName   Person firsName
	 * @param middleName Person middleName
	 * @param lastName  Person lastName
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,ObjectId oid,Institution institution){

		document.put("institution", institution.getInstitution() );
		document.put("university", institution.getUniversity() );
		document.put("institutionTypeId", institution.getInstitutionTypeId() );
	
		return document;
	}
}
