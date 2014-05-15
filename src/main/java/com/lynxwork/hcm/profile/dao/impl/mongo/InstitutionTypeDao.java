package com.lynxwork.hcm.profile.dao.impl.mongo;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.lynxwork.hcm.profile.model.InstitutionType;
import com.lynxwork.hcm.profile.dao.IInstitutionTypeDao;
import com.lynxwork.mdm.person.dao.impl.mongo.PersonDao;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.lynxwork.persistance.exception.SaveEntityException;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class InstitutionTypeDao implements IInstitutionTypeDao{
	static final Logger log = Logger.getLogger(PersonDao.class);
	private static String ENTITY_NAME ="Person";
	MongoDbConnection cnn;
	DB db;

	public InstitutionTypeDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}
	
	public ObjectId save(InstitutionType institutionType) throws SaveEntityException{
		  log.debug( "Save Person Entity in Mongo DB: ");
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  ObjectId oid = new ObjectId();
		  document = getMapEntity(document, oid,institutionType);
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
	public InstitutionType find(String institutionName) {
		InstitutionType institutionType = new InstitutionType();
			//Se obtienen los datos del usuario insertado
			DBCollection findPerson = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("institutionName", institutionName);
			DBCursor cursor = findPerson.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					log.debug(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
					institutionType = setMapEntity(obj,institutionType);
					break;
				}
			} finally {
				   cursor.close();
			}
		return institutionType;
	}


	/**
	 * Mapea los campos de la entidad
	 * @param firsName   Person firsName
	 * @param middleName Person middleName
	 * @param lastName  Person lastName
	 * **/
	public InstitutionType setMapEntity(BasicDBObject obj,InstitutionType institutionType){
		
		institutionType.setInstitutionType(obj.getString("institutionType"));
		institutionType.setInstitutionName(obj.getString("institutionName"));
		institutionType.setDescription(obj.getString("description"));
	
		return institutionType;
	}

	/**
	 * Mapea los campos de la entidad
	 * @param firsName   Person firsName
	 * @param middleName Person middleName
	 * @param lastName  Person lastName
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,ObjectId oid,InstitutionType institutionType){

		document.put("institutionType", institutionType.getInstitutionType() );
		document.put("institutionName", institutionType.getInstitutionName() );
		document.put("description", institutionType.getDescription() );

		return document;
	}
	
	

}
