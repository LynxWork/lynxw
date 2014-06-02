package com.lynxwork.mdm.product.dao;

import java.util.List;

import org.bson.types.ObjectId;

import com.lynxwork.mdm.product.model.Product;
import com.lynxwork.persistance.exception.SaveEntityException;

public interface IProductDao {
	
	public List<Product> findByPersonld(String productName);
	
	public ObjectId save(Product product)  throws SaveEntityException;
	
	Product findById(String productId);

	Product find(String productName);

}
