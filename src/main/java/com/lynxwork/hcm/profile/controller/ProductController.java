package com.lynxwork.hcm.profile.controller;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.lynxwork.mdm.factory.impl.mongo.MongoMasterDataDaoFactory;
import com.lynxwork.mdm.person.dao.IPersonDao;
import com.lynxwork.mdm.product.dao.IProductDao;
import com.lynxwork.mdm.product.model.Product;
import com.lynxwork.mdm.product.service.ProductService;
import com.lynxwork.security.model.User;

@ManagedBean(name = "productController")
@SessionScoped
public class ProductController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8095889047683180944L;
	static final Logger log = Logger.getLogger(ProductController.class);
	
	
	// Product
	private String productId;
	private String name;
	private String description;
	private List<File> ImageList;
	private String productTypeId;
	private String personId;
	// product
	private String isProductRendered;
	private List<Product> productList; // Add Product
	private List<Product> productCatList; // Product calatoge from database
	private List<SelectItem> productOptions = null; // List of product acepted

	// Accion control Pruduct
	boolean isBtnSaveProductRendered = false;
	boolean isBtnCancelProductRendered = true;
	private User user;
	Product product;
	
	public ProductController(){
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<File> getImageList() {
		return ImageList;
	}
	public void setImageList(List<File> imageList) {
		ImageList = imageList;
	}
	public String getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public List<Product> getProductList() {
		List<Product> productList = new ArrayList<Product>();
        MongoMasterDataDaoFactory factory  = new MongoMasterDataDaoFactory();
        IPersonDao personDao = factory.getPersonDao();
        @SuppressWarnings("unused")
		IProductDao productDao = factory.getProductDao();
        try{
        String personId = personDao.findByUserId(user.getUserId()).getPersonId();
        IProductDao productDao1 = factory.getProductDao();
        productList = productDao1.findByPersonld(personId);
        }catch(Exception e){
        	log.error("Error" + e);
        }
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getIsProductRendered() {
		return isProductRendered;
	}
	public void setIsProductRendered(String isProductRendered) {
		this.isProductRendered = isProductRendered;
	}
	public List<Product> getProductCatList() {
		return productCatList;
	}
	public void setProductCatList(List<Product> productCatList) {
		this.productCatList = productCatList;
	}
	public List<SelectItem> getProductOptions() {
		
		return productOptions;
	}
	public void setProductOptions(List<SelectItem> productOptions) {
		this.productOptions = productOptions;
	}
	
	/**
	 * This method add a fields for input data
	 * */
	public String addProduct(){
		log.debug("Init addProdutct");
		isProductRendered = "true";
		log.debug("End addProduct");
		return "";
	}
	
	/**
	 * This method cancel the data of profession addeded
	 * */
	public String cancelAddProduct(){
		log.debug("Init cancelAddProduct");
		isProductRendered = "false";
		log.debug("End cancelAddProduct");
		return "";
	}
		
	public String saveProduct(){
		log.debug("Init saveProduct");
		log.debug("Product id:" + name);
		//log.debug("Person First Name:" + person.toString());
		ProductService productService = new ProductService();
		if(name!=null && name.length()>0){
			Product p = productService.findById(name);
			p.setName(getName());
			productList.add(p);
		}
		log.debug("End saveProduct");
		return "";
	}
	
	public String saveProductData(){
		ProductService productService = new ProductService();
		try {
			productService.saveProduct(product);
			isBtnSaveProductRendered= false;
		} catch (Exception e) {
		}
		
		return"";
	}
	 
	public String cancelProductData(){
		isBtnCancelProductRendered = true;
		return"";
	}

	
	public boolean isBtnSaveProductRendered() {
		return isBtnSaveProductRendered;
	}
	public void setBtnSaveProductRendered(boolean isBtnSaveProductRendered) {
		this.isBtnSaveProductRendered = isBtnSaveProductRendered;
	}
	public boolean isBtnCancelProductRendered() {
		return isBtnCancelProductRendered;
	}
	public void setBtnCancelProductRendered(boolean isBtnCancelProductRendered) {
		this.isBtnCancelProductRendered = isBtnCancelProductRendered;
	}
	
	//product
		public String viewProduct(){
			log.debug("viewProduct");
			return "viewProduct";
		}
		
}
