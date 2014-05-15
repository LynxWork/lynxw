package com.lynxwork.social.graph.engine.dao.impl.mongo;

import org.apache.log4j.Logger;

import com.lynxwork.persistance.connection.MongoDbConnection;
import com.lynxwork.security.dao.impl.mongo.UserDao;
import com.lynxwork.social.graph.engine.dao.IEntityGraphDao;
import com.lynxwork.social.graph.engine.model.EntityGraph;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class EntityGraphDao implements IEntityGraphDao{

	static final Logger log = Logger.getLogger(UserDao.class);
	private static String ENTITY_NAME ="EntityGraph";
	MongoDbConnection cnn;
	DB db;


	public EntityGraphDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}


	public void save(EntityGraph entityGraph){
		boolean resval = false;
		//Se inserta 
		DBCollection collection = db.getCollection( ENTITY_NAME );
		BasicDBObject document = new BasicDBObject();
		document = setMapEntity(document,entityGraph);
		WriteResult wr = collection.insert(document);
		log.debug( "error:" + wr.getError() );
	}
	
	/**
	 * Busca una entidad
	 * @param String entityId id de la entidad buscada
	 * **/
	@Override
	public EntityGraph find(String entityId) {
		    EntityGraph entityGraph = new EntityGraph();
			//Se obtienen los datos del usuario insertado
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("entityId", entityId);
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					log.debug(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();
					entityGraph = getMapEntity(obj,entityGraph);
					break;
				}
			} finally {
				   cursor.close();
			}
			return entityGraph;
	}


	/**
	 * Mapea los campos de la entidad
	 * @param EntityGraph entityGraph
	 * @param BasicDBObject obj
	 * **/
	public EntityGraph getMapEntity(BasicDBObject obj,EntityGraph entityGraph){
		entityGraph.setEntityGraphId( obj.getString("entityGraphId") );
		entityGraph.setEntityId( obj.getString("entityId") );
		entityGraph.setEntityRelationType( obj.getString("entityRelationType") );
		entityGraph.setEntityType( obj.getString("entityType") );
		entityGraph.setEntityRelationStatus( obj.getString("entityRelationStatus") );
		entityGraph.setPartnerId( obj.getString("partnerId") );
		entityGraph.setCreateStamp( obj.getDate("createStamp") );
		entityGraph.setLastUpdatedStamp( obj.getDate("lastUpdatedStamp") );
		return entityGraph;
	}
	
	/**
	 * Mapea los campos de la entidad
	 * @param EntityGraph entityGraph
	 * @param BasicDBObject obj
	 * **/
	public BasicDBObject setMapEntity(BasicDBObject document,EntityGraph entityGraph){
		document.put( "entityGraphId" , entityGraph.getEntityGraphId() );
		document.put( "entityId" , entityGraph.getEntityId() );
		document.put( "entityRelationType" , entityGraph.getEntityRelationType() );
		document.put( "entityType" , entityGraph.getEntityType() );
		document.put( "entityRelationStatus" , entityGraph.getEntityRelationStatus() );
		document.put( "partnerId" , entityGraph.getPartnerId() );
		document.put( "createStamp" , entityGraph.getCreateStamp() );
		document.put( "lastUpdatedStamp" , entityGraph.getLastUpdatedStamp() );
		return document;
	}

}