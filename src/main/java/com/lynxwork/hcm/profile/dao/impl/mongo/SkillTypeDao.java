package com.lynxwork.hcm.profile.dao.impl.mongo;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import com.lynxwork.hcm.profile.dao.ISkillTypeDao;
import com.lynxwork.hcm.profile.model.SkillType;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.lynxwork.persistance.exception.SaveEntityException;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class SkillTypeDao implements ISkillTypeDao{

	static final Logger log = Logger.getLogger(SkillTypeDao.class);
	private static final String ENTITY_NAME ="SkillType";
	MongoDbConnection cnn;
	DB db;
	
	public SkillTypeDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}
	
	public ObjectId save(SkillType skillType) throws SaveEntityException{
		  log.debug( "Save SkillType Entity in Mongo DB: ");
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  ObjectId oid = new ObjectId();
		  document = getMapEntity(document, oid,skillType);
		  WriteResult wr = collection.insert(document);
		  if(wr.getError()!=null){
			  String msgErr = "No fue posible salvar la entidad Skill mongodb ["+wr.getError()+"]";
			  log.debug( msgErr );
			  throw new SaveEntityException(msgErr);
		  }
		  log.debug( "End Save Skill Entity in Mongo DB: ");
		  return oid;
	}
	

	@Override
	public List<SkillType> findByCountry(String countryId, String skillTypeId) {
		log.debug("init findByCountry");
		List<SkillType> skillTypeList = new ArrayList<SkillType>();
		//Se obtienen los datos del Skill insertado
		DBCollection findPerson = db.getCollection(ENTITY_NAME);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("countryId", countryId);
		searchQuery.put("skillTypeId", skillTypeId);
		DBCursor cursor = findPerson.find(searchQuery);
		log.debug("Cursor elements" + cursor.size()); 
		try {
			while (cursor.hasNext()) {
				BasicDBObject obj = (BasicDBObject) cursor.next();
				SkillType skillType = new SkillType();
				skillType = setMapEntity(obj,skillType);
				skillTypeList.add(skillType);
			}
		} finally {
			   cursor.close();
		}
		log.debug("end findByCountry");
		return skillTypeList;
	}

	/**
	 * Mapea los campos de la entidad
	 * **/
	public SkillType setMapEntity(BasicDBObject obj,SkillType skillType){
		skillType.setSkillTypeId( obj.getString("skillTypeId") );
		skillType.setName( obj.getString("name") );
		skillType.setDescription(obj.getString("description"));
		return skillType;
	}

	/**
	 * Mapea los campos de la entidad
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,ObjectId oid,SkillType skillType){
		document.put("skillTypeId", skillType.getSkillTypeId() );
		document.put("name", skillType.getName() );
		document.put("description", skillType.getDescription() );
		return document;
	}


	@Override
	public List<SkillType> findAll(String countryId, String skillTypeId) {
		return null;
	}
	@Override
	public SkillType find(String name) {
		return null;
	}


	@Override
	public SkillType findById(String skillTypeId) {
		return null;
	}

}
