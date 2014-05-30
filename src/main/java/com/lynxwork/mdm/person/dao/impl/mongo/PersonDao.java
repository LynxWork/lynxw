package com.lynxwork.mdm.person.dao.impl.mongo;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.lynxwork.mdm.person.dao.IPersonDao;
import com.lynxwork.mdm.person.model.Person;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.lynxwork.persistance.exception.SaveEntityException;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class PersonDao implements IPersonDao{

	static final Logger log = Logger.getLogger(PersonDao.class);
	private static String ENTITY_NAME ="Person";
	MongoDbConnection cnn;
	DB db;

	public PersonDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}

	public ObjectId save(Person person) throws SaveEntityException{
		  log.debug( "Save Person Entity in Mongo DB: ");
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  ObjectId oid = new ObjectId();
		  document = getMapEntity(document, oid,person);
		  WriteResult wr = collection.insert(document);
		  if(wr.getError()!=null){
			  String msgErr = "No fue posible salvar la entidad Person mongodb ["+wr.getError()+"]";
			  log.debug( msgErr );
			  throw new SaveEntityException(msgErr);
		  }
		  log.debug( "End Save Person Entity in Mongo DB: ");
		  return oid;
	}
    
	public ObjectId savePerson(Person person) throws SaveEntityException{
		  log.debug( "Save Person Entity in Mongo DB: ");
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  ObjectId oid = new ObjectId();
		  document = getMapEntity(document, oid,person);
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
	 * @param lastName   Person lastName
	 * **/
	@Override
	public Person find(String firsName, String middleName, String lastName ) {
		Person person = new Person();
			//Se obtienen los datos del usuario insertado
			DBCollection findPerson = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("firsName", firsName);
			searchQuery.put("middleName",middleName);
			searchQuery.put("lastName",lastName);
			DBCursor cursor = findPerson.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					BasicDBObject obj = (BasicDBObject) cursor.next();
					person = setMapEntity(obj,person);
					break;
				}
			} finally {
				   cursor.close();
			}
		return person;
	}


	/**
	 * Busca una entidad
	 * @param firsName   Person firsName
	 * @param middleName Person middleName
	 * @param lastName   Person lastName
	 * **/
	@Override
	public Person findByUserId(String userId) {
		Person person = new Person();
		//Se obtienen los datos del usuario insertado
		DBCollection findPerson = db.getCollection(ENTITY_NAME);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("userId", userId);
		BasicDBObject basicDBObject = (BasicDBObject)findPerson.findOne(searchQuery);
		person = setMapEntity(basicDBObject,person);
		return person;
	}

	@Override
	public boolean update(Person person){
		boolean reval = false;
		//Query criteria document to update
		BasicDBObject searchQuery = new BasicDBObject().append("userId", person.getUserId());
		//Update document fields
		BasicDBObject newDocument = new BasicDBObject();
		BasicDBObject fieldSets = new BasicDBObject(); 
		fieldSets.put("firsName", person.getFirstName() );
		fieldSets.put("middleName", person.getMiddleName() );
		fieldSets.put("lastName", person.getLastName() );
		fieldSets.put("nin", person.getNin() );
		fieldSets.put("taxid", person.getTaxid() );
		fieldSets.put("ssn", person.getSsn() );
		fieldSets.put("birthday", person.getBirthday() );
		fieldSets.put("stateCivilId", person.getStateCivilId() );
		fieldSets.put("genderId", person.getGenderId() );
		fieldSets.put("blirthplaceId", person.getBirthPlaceId() );
		fieldSets.put("bloodTypeId", person.getBloodTypeId() );
		newDocument.append("$set", fieldSets );
		//Update Document
		DBCollection collection = db.getCollection(ENTITY_NAME);
		WriteResult result = collection.update(searchQuery, newDocument);
		if(result==null){
			reval = true;
		}
		return reval;
	}
	
	
	/**
	 * Mapea los campos de la entidad
	 * @param firsName   Person firsName
	 * @param middleName Person middleName
	 * @param lastName  Person lastName
	 * **/
	public Person setMapEntity(BasicDBObject obj,Person person){
		person.setPersonId(obj.getString("personId"));
		person.setFirstName(obj.getString("firsName"));
		person.setMiddleName(obj.getString("middleName"));
		person.setLastName(obj.getString("lastName"));
		person.setNin(obj.getString("nin"));
		person.setTaxid(obj.getString("taxid"));
		person.setSsn(obj.getString("ssn"));
		person.setBirthday(obj.getDate("birthday"));
		person.setStateCivilId(obj.getString("stateCivilId"));
		person.setGenderId(obj.getString("genderId"));
		person.setBirthPlaceId(obj.getString("blirthplaceId"));
		person.setBloodTypeId(obj.getString("bloodTypeId"));
		return person;
	}

	/**
	 * Mapea los campos de la entidad
	 * @param firsName   Person firsName
	 * @param middleName Person middleName
	 * @param lastName  Person lastName
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,ObjectId oid,Person person){
		document.put("personId", person.getPersonId() );
		document.put("firsName", person.getFirstName() );
		document.put("middleName", person.getMiddleName() );
		document.put("lastName", person.getLastName() );
		document.put("nin", person.getNin() );
		document.put("taxid", person.getTaxid() );
		document.put("ssn", person.getSsn() );
		document.put("birthday", person.getBirthday() );
		document.put("stateCivilId", person.getStateCivilId() );
		document.put("genderId", person.getGenderId() );
		document.put("blirthplaceId", person.getBirthPlaceId() );
		document.put("bloodTypeId", person.getBloodTypeId() );
		document.put("userId", person.getUserId() );
		return document;
	}
}

