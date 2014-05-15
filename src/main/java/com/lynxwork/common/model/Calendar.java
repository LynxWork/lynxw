package com.lynxwork.common.model;

import java.util.Date;
import java.util.Locale;

public class Calendar {
	 
	 private Date date; 
	//Calendar Setings
	 private Locale locale;
	 private boolean popup;
	 private String pattern;
	 private boolean showApply = true;
	 private boolean useCustomDayLabels;
	 private boolean disabled = false;
	 

	 public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	public boolean isPopup() {
		return popup;
	}
	public void setPopup(boolean popup) {
		this.popup = popup;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public boolean isShowApply() {
		return showApply;
	}
	public void setShowApply(boolean showApply) {
		this.showApply = showApply;
	}
	public boolean isUseCustomDayLabels() {
		return useCustomDayLabels;
	}
	public void setUseCustomDayLabels(boolean useCustomDayLabels) {
		this.useCustomDayLabels = useCustomDayLabels;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

}
