package com.lynxwork.mdm.product.dao.impl.mongo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

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
	private static String ENTITY_NAME ="ProductService";
	MongoDbConnection cnn;
	DB db;


	public ProductDao(){
		 cnn = MongoDbConnection.getInstance();
		 db = cnn.getConnection();	
	}
	
	public void save(Product product){
		  //Se inserta 
		  DBCollection collection = db.getCollection( ENTITY_NAME );
		  BasicDBObject document = new BasicDBObject();
		  document = getMapEntity(document,product);
		  WriteResult wr = collection.insert(document);
		  log.debug( "error:" + wr.getError() );
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


	public List<Product> findByUserld (String Userld){
		List<Product> productList = new ArrayList<Product>();
		DBCollection findUser = db.getCollection(ENTITY_NAME);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("Userld", Userld);
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
		product.setProductName( obj.getString("productName") );
		product.setProductDescription( obj.getString("productDescription") );
		product.setProfileId( obj.getString("profileId") );
	return product;
	}

	/**
	 * Mapea los campos de la entidad
	 @param bloodype BloodTypeDao bloodype 
	  * **/
	public BasicDBObject getMapEntity(BasicDBObject document,Product product){
		document.put("productId", product.getProductId() );
		document.put("productName", product.getProductName() );
		document.put("productDescription", product.getProductDescription() );
		document.put("profileId", product.getProfileId() );
		return document;
	}

	@Override
	public Product findById(String productId) {
		return null;
	}

	
}
