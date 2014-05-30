package com.lynxwork.social.publication.dao.impl.mongo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.lynxwork.hcm.profile.model.Profession;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.lynxwork.persistance.exception.SaveEntityException;
import com.lynxwork.social.publication.dao.IPublicationDao;
import com.lynxwork.social.publication.model.Publication;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class PublicationDao implements IPublicationDao{

	static final Logger log = Logger.getLogger(PublicationDao.class);
	private static final String ENTITY_NAME ="Publication";

	MongoDbConnection cnn;
	DB db;
	
	public PublicationDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}
	
	@Override
	public ObjectId save(Publication publication) throws SaveEntityException{
		  log.info( "Save Publication Entity in Mongo DB: ");
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  ObjectId oid = new ObjectId();
		  document = getMapEntity(document, oid,publication);
		  WriteResult wr = collection.insert(document);
		  if(wr.getError()!=null){
			  String msgErr = "No fue posible salvar la entidad Person mongodb ["+wr.getError()+"]";
			  log.error( msgErr );
			  throw new SaveEntityException(msgErr);
		  }
		  log.info( "End Save Profession Entity in Mongo DB: ");
		  return oid;
	}

	@Override
	public List<Publication> findPrimaryPublications(String userId){
		log.info("init findPrimaryPublications");
		List<Publication> publications = new ArrayList<Publication>();
		//Se obtienen los datos del usuario insertado
		DBCollection collection = db.getCollection(ENTITY_NAME);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("userId", userId);
		DBCursor cursor = collection.find(searchQuery).limit(15);
		try {
			while (cursor.hasNext()) {
				BasicDBObject obj = (BasicDBObject) cursor.next();
				Publication publication = new Publication();
				publication = setMapEntity(obj,publication);
				publications.add(publication);
			}
		} finally {
			   cursor.close();
		}
		log.info("end findPrimaryPublications");
		return publications;
	}
	
	/**
	 * Mapea los campos de la entidad
	 * @author Juan Arturo Vargas Torres
	 * @param BasicDBObject obj
	 * **/
	public Publication setMapEntity(BasicDBObject obj,Publication publication){
		publication.setUserId( obj.getString("userId") );
		publication.setDescription( obj.getString("description") );
		publication.setCualification( obj.getInt("cualification") );
		return publication;
	}

	/**
	 * Mapea los campos de la entidad
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,ObjectId oid,Publication publication){
		document.put( "userId", publication.getUserId() );
		document.put( "description", publication.getDescription() );
		document.put( "cualification", publication.getCualification() );
		return document;
	}
	
}
