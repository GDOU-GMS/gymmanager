package com.gms.vo;

public class SiteVo {

	private int id;
	private String type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
