package com.lynxwork.metamodel;

import java.io.Serializable;
import java.util.List;


public class Entity implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 4468631724733964288L;
	
	private Integer id;
    private String name;
    private String title;
    private String description;
    private Entity parentEntity;
	private List<Property> properties;

    public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public Entity(){
    }
	
	public Entity(Integer id){
        this.id = id;
    }
    
    public Entity(Integer id,String name,
            String title,String description,
            Object objectSup){
            super();
            this.id = id;
            this.name = name;
            this.title = title;
            this.description = description;
            this.parentEntity = parentEntity;
    }

    /**
     * @return the idSysObject
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param idSysObject the idSysObject to set
     */
    public void setIdSysObject(Integer id) {
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

    public Entity getParentEntity() {
		return parentEntity;
	}

	public void setParentEntity(Entity parentEntity) {
		this.parentEntity = parentEntity;
	}

    
}
