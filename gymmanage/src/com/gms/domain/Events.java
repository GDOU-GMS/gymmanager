package com.gms.domain;

import java.util.Date;

public class Events {

	private int id;
	private int siteId;
	private Date Startime;
	private Date endTime;
	private String statue;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public Date getStartime() {
		return Startime;
	}
	public void setStartime(Date startime) {
		Startime = startime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getStatue() {
		return statue;
	}
	public void setStatue(String statue) {
		this.statue = statue;
	}
	
	
	
}
