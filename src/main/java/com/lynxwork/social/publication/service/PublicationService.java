package com.lynxwork.social.publication.service;

import java.util.ArrayList;
import java.util.List;

import com.lynxwork.config.SystemConfig;
import com.lynxwork.persistance.exception.SaveEntityException;
import com.lynxwork.social.factory.SocialDaoFactory;
import com.lynxwork.social.publication.dao.IPublicationDao;
import com.lynxwork.social.publication.model.Publication;

public class PublicationService {

	public void save(Publication publication) throws SaveEntityException{
		SocialDaoFactory factory = SocialDaoFactory.getDAOFactory(SystemConfig.SOCIAL_PERSISTENT_REPOSITORY);
		IPublicationDao dao = factory.getPublicationDao();
		dao.save(publication);
	}
	
	public List<Publication> findPrimaryPublications(String userId){
		List<Publication> publications = new ArrayList<Publication>();
		SocialDaoFactory factory = SocialDaoFactory.getDAOFactory(SystemConfig.SOCIAL_PERSISTENT_REPOSITORY);
		IPublicationDao dao = factory.getPublicationDao();
		publications = dao.findPrimaryPublications(userId);
		return publications;
	}
	
}
