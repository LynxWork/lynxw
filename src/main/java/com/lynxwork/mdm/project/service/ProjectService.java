package com.lynxwork.mdm.project.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lynxwork.config.SystemConfig;
import com.lynxwork.hcm.factory.HcmDaoFactory;
import com.lynxwork.mdm.project.dao.IProjectDao;
import com.lynxwork.mdm.project.model.Project;

public class ProjectService {
	static final Logger log = Logger.getLogger(ProjectService.class);
	
	public List<Project> findByUserld(String projectName){
		log.debug("init findByUserld");
		List<Project> projectList = new ArrayList<Project>();
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		IProjectDao projectDao = daoFactory.getProjectDao();
		projectList = projectDao.findByUserld(projectName);
		log.debug("end findByUserld");
		return projectList;
	}
	
	public Project findById(String projectId){
		log.debug("init findById");
		Project project = new Project();
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.MASTER_DATA_PERSISTENT_REPOSITORY);
		IProjectDao projectDao = daoFactory.getProjectDao();
		project = projectDao.findById(projectId);
		log.debug("end findById");
		return project;
	}
	
	public boolean saveProjectInProfileByUserId(String userId, Project project){
		boolean resval = false;
		log.debug("init saveProjectInProfile");
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.HUMAN_CAPITAL_PERSISTENT_REPOSITORY);
		IProjectDao projectDao = daoFactory.getProjectDao();
		resval = projectDao.saveProjectInPersonByUserId(userId, project);
		log.debug("end saveProjectInProfile");
		return resval;
	}

	public List<Project> findByUserId(String userId){
		log.debug("init findByUserId");
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.HUMAN_CAPITAL_PERSISTENT_REPOSITORY);
		IProjectDao projectDao = daoFactory.getProjectDao();
		List<Project> Projects = projectDao.findByUserId(userId);
		log.debug("end findByUserId");
		return Projects;
	}

	public List<Project> findByCountry(String countryId){
		log.debug("init findByCountry");
		List<Project> projectList = new ArrayList<Project>();
		HcmDaoFactory daoFactory = HcmDaoFactory.getDAOFactory(SystemConfig.HUMAN_CAPITAL_PERSISTENT_REPOSITORY);
		IProjectDao projectDao = daoFactory.getProjectDao();
		projectList = projectDao.findByCountry( countryId);
		log.debug("end findByCountry");
		return projectList;
	}

}
