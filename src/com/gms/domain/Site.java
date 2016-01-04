package com.gms.domain;

public class Site {

	private int id;
	private int typeId;
	private String name;
	private String statue;
	private float feeScale;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatue() {
		return statue;
	}
	public void setStatue(String statue) {
		this.statue = statue;
	}
	public float getFeeScale() {
		return feeScale;
	}
	public void setFeeScale(float feeScale) {
		this.feeScale = feeScale;
	}
	
	
}
