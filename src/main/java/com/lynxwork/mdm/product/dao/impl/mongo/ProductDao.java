package com.lynxwork.mdm.product.dao.impl.mongo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import com.lynxwork.mdm.product.dao.IProductDao;
import com.lynxwork.mdm.product.model.Product;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.WriteResult;

public class ProductDao implements IProductDao {

	static final Logger log = Logger.getLogger(ProductDao.class);
	private static String ENTITY_NAME ="Product";
	MongoDbConnection cnn;
	DB db;


	public ProductDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}
	
	public ObjectId save(Product product){
		  //Se inserta 
		  ObjectId oid = new ObjectId(); //Se construye el id
		  product.setProductId(oid.toString());
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  document = getMapEntity(document,product);
		  WriteResult wr = collection.insert(document);
		  log.debug( "error:" + wr.getError() );
		return oid;
	}

	/**
	 * Busca una entidad
	 * @param email User email
	 * @param password User password
	 * **/
	@Override
	public Product find(String productName) {
		Product product = new Product();
			//Se obtienen los datos del usuario insertado
			DBCollection findUser = db.getCollection(ENTITY_NAME);
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("productName", productName);
			DBCursor cursor = findUser.find(searchQuery);
			try {
				while (cursor.hasNext()) {
					BasicDBObject obj = (BasicDBObject) cursor.next();
					product = setMapEntity(obj,product);
					break;
				}
			} finally {
				   cursor.close();
			}
		return product;
	}


	public List<Product> findByPersonld (String personld){
		List<Product> productList = new ArrayList<Product>();
		DBCollection findUser = db.getCollection(ENTITY_NAME);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("Personld", personld);
		DBCursor cursor = findUser.find(searchQuery);
		try {
			while (cursor.hasNext()) {
				log.debug(cursor.next());
				BasicDBObject obj = (BasicDBObject) cursor.next();
				Product product = new Product();
				product = setMapEntity(obj,product);
				productList.add(product);
			}
		} finally {
			   cursor.close();
		}
	return productList;
	}
	
	
	/**
	 * Mapea los campos de la entidad
	 * @param bloodype BloodTypeDao bloodype 
	 * **/
	public Product setMapEntity(BasicDBObject obj,Product product){
		product.setProductId( obj.getString("productId") );
		product.setName( obj.getString("productName") );
		product.setDescription( obj.getString("productDescription") );
		product.setPersonId( obj.getString("personId") );
		product.setProductTypeId( obj.getString("productTypeId") );
	return product;
	}

	/**
	 * Mapea los campos de la entidad
	 @param bloodype BloodTypeDao bloodype 
	  * **/
	public BasicDBObject getMapEntity(BasicDBObject document,Product product){
		document.put("productId", product.getProductId() );
		document.put("productName", product.getName() );
		document.put("productDescription", product.getDescription() );
		document.put("personId", product.getPersonId() );
		document.put("productTypeId", product.getProductTypeId() );
		return document;
	}

	@Override
	public Product findById(String productId) {
		return null;
	}

	
}
