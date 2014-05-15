package com.lynxwork.hcm.profile.model;

import java.io.Serializable;

public class Summary implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2513985145310439228L;
	private String   summaryId;
	private String   title;
	private String   company;
	private String   initMonth;
	private String   initYear;
	private String   endMonth;
	private String   endYear;
	private String   isCurrentWork;
	private String   summary;
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getInitMonth() {
		return initMonth;
	}
	public void setInitMonth(String initMonth) {
		this.initMonth = initMonth;
	}
	public String getInitYear() {
		return initYear;
	}
	public void setInitYear(String initYear) {
		this.initYear = initYear;
	}
	public String getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	public String getIsCurrentWork() {
		return isCurrentWork;
	}
	public void setIsCurrentWork(String isCurrentWork) {
		this.isCurrentWork = isCurrentWork;
	}
	public String getSummaryId() {
		return summaryId;
	}
	public void setSummaryId(String summaryId) {
		this.summaryId = summaryId;
	}
	
}
