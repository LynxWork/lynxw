package com.lynxwork.hcm.profile.dao.impl.mongo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.lynxwork.hcm.profile.dao.ISkillDao;
import com.lynxwork.hcm.profile.model.Skill;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.lynxwork.persistance.exception.SaveEntityException;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class SkillDao implements ISkillDao{
	
	static final Logger log = Logger.getLogger(SkillDao.class);
	private static final String ENTITY_NAME ="Skill";
	MongoDbConnection cnn;
	DB db;
	
	public SkillDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}
	
	
	public ObjectId save(Skill skill) throws SaveEntityException{
		  log.debug( "Save Skill Entity in Mongo DB: ");
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  ObjectId oid = new ObjectId();
		  document = getMapEntity(document, oid,skill);
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
	public List<Skill> findByCountry(String countryId, String skillTypeId) {
		log.debug("init findByCountry");
		List<Skill> skillList = new ArrayList<Skill>();
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
				Skill skill = new Skill();
				skill = setMapEntity(obj,skill);
				skillList.add(skill);
			}
		} finally {
			   cursor.close();
		}
		log.debug("end findByCountry");
		return skillList;
	}

	/**
	 * Mapea los campos de la entidad
	 * **/
	public Skill setMapEntity(BasicDBObject obj,Skill skill){
		skill.setSkillId( obj.getString("skillId") );
		skill.setName( obj.getString("name") );
		skill.setDescription(obj.getString("description"));
		skill.setYearsExperience(obj.getInt("yearsExperience"));
		skill.setLevelKnowledge(obj.getInt("levelKnowledge"));
		skill.setSkillTypeId(obj.getString("skillTypeId"));
		return skill;
	}

	/**
	 * Mapea los campos de la entidad
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,ObjectId oid,Skill skill){
		document.put("skillId", skill.getSkillId() );
		document.put("name", skill.getName() );
		document.put("description", skill.getDescription() );
		document.put("yearsExperience", skill.getYearsExperience() );
		document.put("levelKnowledge", skill.getLevelKnowledge() );
		document.put("skillTypeId", skill.getSkillTypeId() );
		return document;
	}


	@Override
	public List<Skill> find(String countryId, String name) {
		return null;
	}


	


	
}
