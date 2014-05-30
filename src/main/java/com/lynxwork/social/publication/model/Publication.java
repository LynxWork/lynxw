package com.lynxwork.social.publication.model;

import java.util.Date;
import java.util.List;

import com.lynxwork.security.model.User;

public class Publication {

	private String description;
	private Integer cualification;
	private List<Comment> comments;
	private String userId;
	private User user;
	
	//Audit Fields
	private Date createDate;
	private String creatorId;
	private String creatoIp;
	private Date lastUpdateDate;
	private String lastUpdaterId;
	private String lastUpdaterIp;

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
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public String getCreatoIp() {
		return creatoIp;
	}
	public void setCreatoIp(String creatoIp) {
		this.creatoIp = creatoIp;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getLastUpdaterId() {
		return lastUpdaterId;
	}
	public void setLastUpdaterId(String lastUpdaterId) {
		this.lastUpdaterId = lastUpdaterId;
	}
	public String getLastUpdaterIp() {
		return lastUpdaterIp;
	}
	public void setLastUpdaterIp(String lastUpdaterIp) {
		this.lastUpdaterIp = lastUpdaterIp;
	}
	
}
