package com.lynxwork.mdm.project.dao;

import java.util.List;

import com.lynxwork.mdm.project.model.Project;

public interface IProjectDao {

	 public Project find(String projectName);
	 
	 public  List<Project> findByUserld (String projectName);

	 public Project findById(String projectId);

	public boolean saveProjectInPersonByUserId(String userId, Project project);

	public List<Project> findByUserId(String userId);

	public List<Project> findByCountry(String countryId);

}
