/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lynxwork.metamodel;

import java.io.Serializable;

/**
 *
 * @author Juan Arturo Vargas Torres
 */
public class DataType implements Serializable{

    private Integer idDataType;
    private String name;
    private String description;

    public DataType(Integer idDataType) {
		super();
		this.idDataType = idDataType;
	}
    
    public DataType(Integer idDataType,String name,String description) {
		super();
		this.idDataType = idDataType;
		this.name = name;
		this.description = description;
	}

    public DataType(){
    	
    }
    
	public void DataType(Integer idDataType, String name, String description){
        this.setIdDataType(idDataType);
        this.setName(name);
        this.setDescription(description);
    }

    /**
     * @return the idDataType
     */
    public Integer getIdDataType() {
        return idDataType;
    }

    /**
     * @param idDataType the idDataType to set
     */
    public void setIdDataType(Integer idDataType) {
        this.idDataType = idDataType;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
