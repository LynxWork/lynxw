package com.lynxwork.hcm.work.dao.impl.mongo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.lynxwork.hcm.work.dao.IWorkTypeDao;
import com.lynxwork.hcm.work.model.WorkType;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class WorkTypeDao implements IWorkTypeDao {

	static final Logger log = Logger.getLogger(WorkCategoryDao.class);
	private static final String ENTITY_NAME ="WorkType";
	private static final String PROPERTY_ID = "_id";
	private static final String PROPERTY_WORK_TYPE_ID = "workTypeId";
	private static final String PROPERTY_NAME = "name";
	private static final String PROPERTY_DESCRIPTION = "description";
	private static final String PROPERTY_COUNTRY_ID = "countryId";

	
	
	MongoDbConnection cnn;
	DB db;

	public WorkTypeDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}

	@Override
	public List<WorkType> findByCountryId(String countryId) {
		log.debug("init WorkTypeDao.findByCountry");
		List<WorkType> list = new ArrayList<WorkType>();
		//Se obtienen los datos del usuario insertado
		DBCollection findPerson = db.getCollection(ENTITY_NAME);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put(PROPERTY_COUNTRY_ID, countryId);
		DBCursor cursor = findPerson.find(searchQuery);
		log.debug("Cursor elements" + cursor.size()); 
		try {
			while (cursor.hasNext()) {
				BasicDBObject obj = (BasicDBObject) cursor.next();
				WorkType workType = new WorkType();
				workType = setMapEntity(obj,workType);
				list.add(workType);
			}
		} finally {
			   cursor.close();
		}
		log.debug("end WorkTypeDao.findByCountry");
		return list;
	}

	/**
	 * Mapea los campos de la entidad
	 * **/
	public WorkType setMapEntity(BasicDBObject obj,WorkType workType){
		workType.set_id(obj.getObjectId(PROPERTY_ID).toString());
		workType.setWorkTypeId( obj.getString(PROPERTY_WORK_TYPE_ID) );
		workType.setName( obj.getString(PROPERTY_NAME) );
		workType.setDescription(obj.getString(PROPERTY_DESCRIPTION));
		workType.setCountryId(obj.getString(PROPERTY_COUNTRY_ID));
		return workType;
	}

	/**
	 * Mapea los campos de la entidad
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,ObjectId oid,WorkType workType){
		document.put(PROPERTY_ID, oid.toString() );
		document.put("PROPERTY_WORK_TYPE_ID", workType.getWorkTypeId() );
		document.put("PROPERTY_NAME", workType.getName() );
		document.put("PROPERTY_DESCRIPTION", workType.getDescription() );
		document.put("PROPERTY_COUNTRY_ID", workType.getCountryId() );
		return document;
	}

}
