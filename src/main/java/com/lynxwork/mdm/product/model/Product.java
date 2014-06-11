package com.lynxwork.mdm.product.model;
import java.io.File;
import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4441180363013089417L;
	
	private String productId;
	private String name;
	private String description;
	private String productTypeId;
	private String personId;
	private List<File> ImageList;
	
	public String getProductId()
	{
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}
	public List<File> getImageList() {
		return ImageList;
	}
	public void setImageList(List<File> imageList) {
		ImageList = imageList;
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
}
