package com.gms.domain;

import java.util.List;

public class Equipment {

	private int id;
	private int typeId;
	private int loanable;
	private int totalNum;
	private int underRepair;
	private String name;
	private String type;
	private String description;
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
	public int getLoanable() {
		return loanable;
	}
	public void setLoanable(int loanable) {
		this.loanable = loanable;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public int getUnderRepair() {
		return underRepair;
	}
	public void setUnderRepair(int underRepair) {
		this.underRepair = underRepair;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getFeeScale() {
		return feeScale;
	}
	public void setFeeScale(float feeScale) {
		this.feeScale = feeScale;
	}

	
	
}
