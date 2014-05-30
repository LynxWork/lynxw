package com.lynxwork.social.publication.dao;

import java.util.List;

import org.bson.types.ObjectId;

import com.lynxwork.persistance.exception.SaveEntityException;
import com.lynxwork.social.publication.model.Publication;

public interface IPublicationDao {

	public ObjectId save(Publication publication) throws SaveEntityException;

	public List<Publication> findPrimaryPublications(String userId);

}
