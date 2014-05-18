package com.lynxwork.mdm.project.dao.impl.mongo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lynxwork.mdm.project.dao.IProjectDao;
import com.lynxwork.mdm.project.model.Project;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class ProjectDao implements IProjectDao {
	static final Logger log = Logger.getLogger(ProjectDao.class);
	private static String ENTITY_NAME ="Project";
	MongoDbConnection cnn;
	DB db;
	
	public ProjectDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}
	
	public void save(Project project){
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  document = getMapEntity(document,project);
		  WriteResult wr = collection.insert(document);
		  log.debug( "error:" + wr.getError() );
		 }
	/**
	 * Busca una entidad
	 * @param email User email
	 * @param password User password
	 * **/
	@Override
	public Project find(String projectName) {
		Project project = new Project();
			//Se obtienen los datos del usuario insertado
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("projectName", projectName);
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					BasicDBObject obj = (BasicDBObject) cursor.next();
					project = setMapEntity(obj,project);
					break;
				}
			} finally {
				   cursor.close();
			}
		return project;
	}


	public List<Project> findByUserld (String Userld){
		List<Project> projectList = new ArrayList<Project>();
		DBCollection findUser = db.getCollection(ENTITY_NAME);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("Userld", Userld);
		DBCursor cursor = findUser.find(searchQuery);
		try {
			while (cursor.hasNext()) {
				log.debug(cursor.next());
				BasicDBObject obj = (BasicDBObject) cursor.next();
				Project project = new Project();
				project = setMapEntity(obj,project);
				projectList.add(project);
			}
		} finally {
			   cursor.close();
		}
	return projectList;
	}
	/**
	 * Mapea los campos de la entidad
	 * @param bloodype BloodTypeDao bloodype 
	 * **/
	public Project setMapEntity(BasicDBObject obj,Project project){
		project.setNameProject( obj.getString("nameProject") );
		project.setNameCompany( obj.getString("nameCompany") );
		project.setStatusProject( obj.getString("statusProject") );
		project.setDescriptionProject( obj.getString("descriptionProject") );
	return project;
	}

	/**
	 * Mapea los campos de la entidad
	 @param bloodype BloodTypeDao bloodype 
	  * **/
	public BasicDBObject getMapEntity(BasicDBObject document,Project project){
		document.put("nameProject", project.getNameProject() );
		document.put("nameCompany", project.getNameCompany() );
		document.put("statusProject", project.getStatusProject() );
		document.put("descriptionProject", project.getDescriptionProject() );
		return document;
	}

	@Override
	public Project findById(String projectId) {
		return null;
	}

	@Override
	public boolean saveProjectInPersonByUserId(String userId, Project project) {
		return false;
	}

	@Override
	public List<Project> findByUserId(String userId) {
		return null;
	}

	@Override
	public List<Project> findByCountry(String countryId) {
		return null;
	}

}
