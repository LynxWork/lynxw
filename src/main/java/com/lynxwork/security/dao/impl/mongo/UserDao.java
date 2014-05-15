package com.lynxwork.security.dao.impl.mongo;

import com.lynxwork.common.exception.ParameterException;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.lynxwork.persistance.exception.SaveEntityException;
import com.lynxwork.security.dao.IUserDao;
import com.lynxwork.security.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

public class UserDao implements IUserDao{
	
	static final Logger log = Logger.getLogger(UserDao.class);
	private static String ENTITY_NAME ="User";
	MongoDbConnection cnn;
	DB db;

	public UserDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}

	public ObjectId save(User user) throws SaveEntityException{
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  ObjectId oid = new ObjectId();
		  log.debug("User oid: " + oid.toString());
		  document = getMapEntity(document,oid,user);
		  WriteResult wr = collection.insert(document);
		  if(wr.getError()!=null){
			  String msgErr = "No fue posible salvar la entidad User mongodb ["+wr.getError()+"]";
			  log.debug( msgErr );
			  throw new SaveEntityException(msgErr);
		  }
		  return oid;
	}
	
	/**
	 * Busca una entidad
	 * @param email User email
	 * @param password User password
	 * **/
	@Override
	public User find(String email, String currentsPassword) throws ParameterException{
		User user = new User();
		if(email!=null && currentsPassword!=null){
			log.debug("Search user in mongo db");
			//Se obtienen los datos del usuario insertado
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("email", email);
			searchQuery.put("currentsPassword",currentsPassword);
			DBCursor cursor = findUser.find(searchQuery);
			log.info("Mongo Collection Size: " + cursor.size());
			try {
				while (cursor.hasNext()) {
					BasicDBObject obj = (BasicDBObject) cursor.next();
					user = setMapEntity(obj,user);
					break;
				}
			} finally {
				   cursor.close();
			}
			log.debug("End Search user in mongo db");
		}else{
			throw new ParameterException("Parametros invalidos");
		}
		return user;
	}

	/**
	 * Mapea los campos de la entidad
	 * @param email User email
	 * @param password User password
	 * **/
	public User setMapEntity(BasicDBObject obj,User user){
		log.info("Init Mapping User Object" );
		user.set_id(obj.getObjectId("_id").toString() );
		user.setUserId( obj.getObjectId("_id").toString() );
		user.setCurrentsPassword( obj.getString("currentsPassword") );
		user.setPasswordHint( obj.getString("passwordHint") );
		user.setIsSystem( obj.getString("isSystem") );
		user.setEnabled( obj.getString("enabled") );
		user.setHasLoggedOut( obj.getString("hasLoggedOut") );
		user.setRequierePasswordChange( obj.getString("requierePasswordChange") );
		user.setLastCurrencyUom( obj.getString("lastCurrencyUom") );
		user.setLastLocale( obj.getString("lastLocale") );
		user.setLastTimeZone( obj.getString("lastTimeZone") );
		user.setDisabledDataTime( obj.getDate("disabledDataTime") );
		user.setSuccessiveFailedLogins( obj.getInt("successiveFailedLogins") );
		user.setExternalAuthId( obj.getString("externalAuthId") );
		user.setUserLdapDn( obj.getString("userLdapDn") );
		user.setIsBasicProfileComplete( obj.getString("isBasicProfileComplete") );
		user.setLastUpdatedStamp( obj.getDate("lastUpdatedStamp") );
		user.setLastUpdatedTxStamp( obj.getDate("lastUpdatedTxStamp") );
		user.setCreatedStamp( obj.getDate("createdStamp") );
		user.setCreatedTxStamp( obj.getDate("createdTxStamp") );
		user.setEmail( obj.getString("email") );
		user.setRatings( obj.getInt("ratings") );	
		log.info("End Mapping User Object" );
		return user;
	}

	/**
	 * Mapea los campos de la entidad
	 * @param email User email
	 * @param password User password
	 * **/
	public BasicDBObject getMapEntity(BasicDBObject document,ObjectId oid,User user){
		document.put("_id", oid );
		document.put("userId", user.getUserId() );
		document.put("currentsPassword", user.getCurrentsPassword() );
		document.put("passwordHint", user.getPasswordHint() );
		document.put("isSystem", user.getIsSystem() );
		document.put("enabled", user.getEnabled() );
		document.put("hasLoggedOut", user.getHasLoggedOut() );
		document.put("requierePasswordChange", user.getRequierePasswordChange() );
		document.put("lastCurrencyUom", user.getLastCurrencyUom() );
		document.put("lastLocale", user.getLastLocale() );
		document.put("lastTimeZone", user.getLastTimeZone() );
		document.put("disabledDataTime", user.getDisabledDataTime() );
		document.put("successiveFailedLogins", user.getSuccessiveFailedLogins() );
		document.put("externalAuthId", user.getExternalAuthId() );
		document.put("userLdapDn", user.getUserLdapDn() );
		document.put("isBasicProfileComplete", user.getIsBasicProfileComplete() );
		document.put("lastUpdatedStamp", user.getLastUpdatedStamp());
		document.put("lastUpdatedTxStamp", user.getLastUpdatedTxStamp());
		document.put("createdStamp", user.getCreatedStamp());
		document.put("createdTxStamp", user.getCreatedTxStamp());
		document.put("email", user.getEmail());
		document.put("ratings", user.getRatings());
		return document;
	}
	
	
}