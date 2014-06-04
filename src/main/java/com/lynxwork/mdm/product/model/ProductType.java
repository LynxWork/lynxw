package com.lynxwork.mdm.product.model;

import java.io.File;
import java.util.List;

public class ProductType {

	private String productTypeId;
	private String Name;
	private String Description;
	private List<File> ImageList;
	private String personId;
	
	public String getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public List<File> getImageList() {
		return ImageList;
	}
	public void setImageList(List<File> imageList) {
		ImageList = imageList;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
	
}
