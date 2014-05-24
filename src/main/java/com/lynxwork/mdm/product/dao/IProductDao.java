package com.lynxwork.mdm.product.dao;

import java.util.List;

import com.lynxwork.mdm.product.model.Product;

public interface IProductDao {
	
	public List<Product> findByPersonld(String productName);
	
	Product findById(String productId);

	Product find(String productName);

}
