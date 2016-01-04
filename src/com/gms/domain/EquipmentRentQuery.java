package com.gms.domain;

import java.util.List;
import java.util.Date;

public class EquipmentRentQuery {
      private int id;
      private int equipmentId;
      private String equipmentname;
      private int userId;
      private String username;
      private String studentNo;
      private Date startDate;
      private Date endDate;
      private float price;
      private int num;
      private String statue;
      private String name;
      
      
      
	public String getEquipmentname() {
		return equipmentname;
	}
	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getStatue() {
		return statue;
	}
	public void setStatue(String statue) {
		this.statue = statue;
	}
      
      
}
