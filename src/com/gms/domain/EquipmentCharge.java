package com.gms.domain;

import java.util.List;

public class EquipmentCharge {
     private int id;
     private int equipmentId;
     private float feescale;
     private String name;
     private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}
	public float getFeescale() {
		return feescale;
	}
	public void setFeescale(float feescale) {
		this.feescale = feescale;
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
     
     
}
