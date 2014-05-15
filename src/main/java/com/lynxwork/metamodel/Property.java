/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lynxwork.metamodel;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author kmejia
 */
public class Property implements Serializable{

    private Integer id;
    private String name;
    private Object value;
	private String title;
    private String description;
    private Integer lenght;
	private Integer width;
    private boolean required;
    private Integer order;
    private boolean isNillable;
	private boolean isSortable;
    private boolean isRequired;
    private boolean isfinding;
    private DataType dataType;
    private RegularExpression regularExpression;
    private Entity entity;


    public boolean isSortable() {
		return isSortable;
	}

	public void setSortable(boolean isSortable) {
		this.isSortable = isSortable;
	}

	public boolean isIsfinding() {
		return isfinding;
	}

	public void setIsfinding(boolean isfinding) {
		this.isfinding = isfinding;
	}

	public boolean isRequired() {
		return isRequired;
	}

    public Integer getLenght() {
		return lenght;
	}

	public void setLenght(Integer lenght) {
		this.lenght = lenght;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setSysObject(Entity entity) {
		this.entity = entity;
	}

	public void setNillable(boolean isNillable) {
		this.isNillable = isNillable;
	}

	public Property(){}
    
    public Property(Integer id) {
		super();
		this.id = id;
	}

	public Property(Integer id
    ,String name
    ,String title
    ,String description
    ,Integer lentght
    ,boolean required
    ,Integer order
    ,DataType dataType
    ,RegularExpression regularExpression){
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.lenght = lenght;
        this.required = required;
        this.order = order;
        this.dataType = dataType;
        this.regularExpression = regularExpression;
    }

    /**
     * @return the idProperty
     */
    public Integer getIdProperty() {
        return id;
    }

    /**
     * @param idProperty the idProperty to set
     */
    public void setIdProperty(Integer id) {
        this.id = id;
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

    public Object getValue() {
		return value;
	}

    /**
     * @param value the value to set
     */
	public void setValue(Object value) {
		this.value = value;
	}
	
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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



    /**
     * @return the required
     */
    public boolean getRequired() {
        return required;
    }

    /**
     * @param required the required to set
     */
    public void setRequired(boolean required) {
        this.required = required;
    }

    /**
     * @return the order
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * @return the dataType
     */
    public DataType getDataType() {
        return dataType;
    }

    /**
     * @param dataType the dataType to set
     */
    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    /**
     * @return the regularExpression
     */
    public RegularExpression getRegularExpression() {
        return regularExpression;
    }

    /**
     * @param regularExpression the regularExpression to set
     */
    public void setRegularExpression(RegularExpression regularExpression) {
        this.regularExpression = regularExpression;
    }

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}


	public boolean getIsNillable() {
		return isNillable;
	}

	public void setIsNillable(boolean isNillable) {
		this.isNillable = isNillable;
	}




}
