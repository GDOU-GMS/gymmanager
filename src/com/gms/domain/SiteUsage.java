package com.gms.domain;

import java.util.Date;

public class SiteUsage {

	private int id;
	private Date stratTime;
	private Date endTime;
	private float price;
	private int userId;
	private int siteId;
	private String  statue;// timeout notimeout
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStratTime() {
		return stratTime;
	}
	public void setStratTime(Date stratTime) {
		this.stratTime = stratTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public String getStatue() {
		return statue;
	}
	public void setStatue(String statue) {
		this.statue = statue;
	}
	
	
	
}
