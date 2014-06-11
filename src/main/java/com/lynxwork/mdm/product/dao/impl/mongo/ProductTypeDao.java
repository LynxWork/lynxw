package com.lynxwork.mdm.product.dao.impl.mongo;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.lynxwork.mdm.product.model.ProductType;
import com.lynxwork.persistance.connection.MongoDbConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class ProductTypeDao {
	
	static final Logger log = Logger.getLogger(ProductTypeDao.class);
	private static String ENTITY_NAME ="ProductType";
	MongoDbConnection cnn;
	DB db;
	
	public List<ProductType> findByPersonld (String productTypeId){
		List<ProductType> productTypeList = new ArrayList<ProductType>();
		DBCollection findUser = db.getCollection(ENTITY_NAME);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("productTypeId", productTypeId);
		DBCursor cursor = findUser.find(searchQuery);
		try {
			while (cursor.hasNext()) {
				log.debug(cursor.next());
				BasicDBObject obj = (BasicDBObject) cursor.next();
				ProductType productType = new ProductType();
				productType = setMapEntity(obj,productType);
				productTypeList.add(productType);
			}
		} finally {
			   cursor.close();
		}
	return productTypeList;
	}
	
	/**
	 * Mapea los campos de la entidad
	 * @param bloodype BloodTypeDao bloodype 
	 * **/
	public ProductType setMapEntity(BasicDBObject obj,ProductType ProductType){
		ProductType.setProductTypeId( obj.getString("productTypeId") );
		ProductType.setName( obj.getString("productName") );
		ProductType.setDescription( obj.getString("productDescription") );
		ProductType.setPersonId( obj.getString("personId") );
	return ProductType;
	}

	/**
	 * Mapea los campos de la entidad
	 @param bloodype BloodTypeDao bloodype 
	  * **/
	public BasicDBObject getMapEntity(BasicDBObject document,ProductType productType){
		document.put("productTypeId", productType.getProductTypeId() );
		document.put("productName", productType.getName() );
		document.put("productDescription", productType.getDescription() );
		document.put("personId", productType.getPersonId() );
		return document;
	}

	


}
