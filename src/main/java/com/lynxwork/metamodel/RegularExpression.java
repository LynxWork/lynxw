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
public class RegularExpression implements Serializable{

    private Integer idRegularExpression;
    private String name;
    private String configuration;
    private String description;

    public RegularExpression(){
    	
    }

    public RegularExpression(Integer idRegularExpression,
    String name,
    String configuration,
    String description){
        this.idRegularExpression = idRegularExpression;
        this.name = name;
        this.configuration = configuration;
        this.description = description;
    }

    /**
     * @return the idRegularExpression
     */
    public Integer getIdRegularExpression() {
        return idRegularExpression;
    }

    /**
     * @param idRegularExpression the idRegularExpression to set
     */
    public void setIdRegularExpression(Integer idRegularExpression) {
        this.idRegularExpression = idRegularExpression;
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
     * @return the configuration
     */
    public String getConfiguration() {
        return configuration;
    }

    /**
     * @param configuration the configuration to set
     */
    public void setConfiguration(String configuration) {
        this.configuration = configuration;
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

	public RegularExpression(Integer idRegularExpression) {
		super();
		this.idRegularExpression = idRegularExpression;
	}

}
