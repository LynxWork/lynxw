package com.lynxwork.social.graph.engine.dao;

import com.lynxwork.social.graph.engine.model.EntityGraph;

public interface IEntityGraphDao {

	public void save(EntityGraph entity);
	public EntityGraph find(String entityId);
	
}
