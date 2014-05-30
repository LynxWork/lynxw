package com.lynxwork.social.publication.model;

import com.lynxwork.security.model.User;

public class Comment {
	private String description;
	private Integer cualification;
	private String userId;
	private User user;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCualification() {
		return cualification;
	}
	public void setCualification(Integer cualification) {
		this.cualification = cualification;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
