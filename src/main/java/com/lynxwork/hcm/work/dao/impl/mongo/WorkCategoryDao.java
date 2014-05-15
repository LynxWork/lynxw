package com.lynxwork.hcm.work.dao.impl.mongo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.lynxwork.hcm.work.dao.IWorkCategoryDao;
import com.lynxwork.hcm.work.model.WorkCategory;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class WorkCategoryDao implements IWorkCategoryDao{

	static final Logger log = Logger.getLogger(WorkCategoryDao.class);
	
	private static String ENTITY_NAME ="WorkCategory";
	MongoDbConnection cnn;
	DB db;
	
	public WorkCategoryDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}
	
	@Override
	public List<WorkCategory> findByCountry(String countryId) {
		log.debug("init findByCountry");
		List<WorkCategory> list = new ArrayList<WorkCategory>();
		//Se obtienen los datos del usuario insertado
		DBCollection findPerson = db.getCollection(ENTITY_NAME);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("countryId", countryId);
		DBCursor cursor = findPerson.find(searchQuery);
		log.debug("Cursor elements" + cursor.size()); 
		try {
			while (cursor.hasNext()) {
				BasicDBObject obj = (BasicDBObject) cursor.next();
				WorkCategory workCategory = new WorkCategory();
				workCategory = setMapEntity(obj,workCategory);
				list.add(workCategory);
			}
		} finally {
			   cursor.close();
		}
		log.debug("end findByCountry");
		return list;
	}

	/**
	 * Mapea los campos de la entidad
	 * **/
	public WorkCategory setMapEntity(BasicDBObject obj,WorkCategory workCategory){
		workCategory.set_id(obj.getObjectId("_id").toString());
		workCategory.setWorkCategoryId( obj.getString("workCategoryId") );
		workCategory.setName( obj.getString("name") );
		workCategory.setDescription(obj.getString("description"));
		workCategory.setCountryId(obj.getString("countryId"));
		return workCategory;
	}

	/**
	 * Mapea los campos de la entidad
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,ObjectId oid,WorkCategory workCategory){
		document.put("_id", oid.toString() );
		document.put("workCategoryId", workCategory.getWorkCategoryId() );
		document.put("name", workCategory.getName() );
		document.put("description", workCategory.getDescription() );
		document.put("countryId", workCategory.getCountryId() );
		return document;
	}

}
