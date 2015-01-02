package com.gms.service.impl;

import java.util.List;

import com.gms.dao.EquipmentChargeDAO;
import com.gms.dao.EquipmentDAO;
import com.gms.dao.EquipmentRentQueryDAO;
import com.gms.domain.Equipment;
import com.gms.domain.EquipmentRentQuery;
import com.gms.domain.EquipmentCharge;
import com.gms.domain.Page;
import com.gms.factory.DAOFactory;

public class EquipmentBusinessServiceImpl {

	DAOFactory daoFactory = DAOFactory.getInstance();
	private EquipmentDAO equipmentDAO = daoFactory.createDAO("com.gms.dao.impl.EquipmentDAOImpl");
	private EquipmentRentQueryDAO equipmentRentQueryDAO = daoFactory.createDAO("com.gms.dao.impl.EquipmentRentQueryDAOImpl");
    private EquipmentChargeDAO equipmentChargeDAO=daoFactory.createDAO("com.gms.dao.impl.EquipmentChargeDAOImpl");

	
	/**
	 * 器材信息
	 * @return
	 */
	public List<Equipment> getAllEquipment() {
		return equipmentDAO.getAllEquipment();
	}

  /**
   * 添加器材
   * @param equipment
   */
	public void addEquipment(Equipment equipment) {
		// TODO Auto-generated method stub
		equipmentDAO.addEquipment(equipment);
	}
     /**
      * 更新器材
      * @param equipment
      */
	public void updateEquipment(Equipment equipment) {
		// TODO Auto-generated method stub
		equipmentDAO.updateEquipment(equipment);
		
	}
     /**
      * 器材租借信息
      * @return
      */
	public List<EquipmentRentQuery> getAllEquipmentRent() {
		// TODO Auto-generated method stub
		return equipmentRentQueryDAO.getAllEquipmentRent();
	}
	
	/**
	 * 获得器材信息分页数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public Page getAllEquipmentPageData(int pageNum,int pageSize ){
		int totalRecord = equipmentDAO.getTotalRecord();
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<Equipment> list = equipmentDAO.getAllEquipmentPageData(page.getStartIndex(), pageSize);
		page.setList(list);
		return page;
	}
	 

	 /**
	  * 删除器材
	  * @param id
	  */
	public void deleteEquipment(int id) {
		// TODO Auto-generated method stub
		equipmentDAO.deleteEquipment(id);
	}
	
	
	 public Page getAllEquipmentRentQueryPageData(int pageNum,int pageSize ){
			int totalRecord = equipmentRentQueryDAO.getTotalRecord();
			Page page = new Page(pageSize, pageNum, totalRecord);
			List<EquipmentRentQuery> list = equipmentRentQueryDAO.getAllEquipmentRentQueryPageData(page.getStartIndex(), 
					pageSize);
			page.setList(list);
			return page;
		}

	public Page queryEquipment(String type, int pageNum,int pageSize) {
		if("none".equals(type)){
			type="";
		}
		int totalRecord = equipmentDAO.getTotalRecord();
		Page page = new Page( pageNum,pageSize, totalRecord);
		List<Equipment> list = equipmentDAO.queryEquipment(type, page.getStartIndex(),pageSize);
		page.setList(list);
		return page;
	}

	public void addEquipRentInfo(EquipmentRentQuery equipmentRents) {
		// TODO Auto-generated method stub
		equipmentRentQueryDAO.addEquipRentInfo(equipmentRents);
	}

	public void deleteEquipmentInfo(int id) {
		// TODO Auto-generated method stub
		equipmentRentQueryDAO.deleteEquipmentInfo(id);
	}
	
	public void updateEquipmentInfo(EquipmentRentQuery equipmentRents) {
		// TODO Auto-generated method stub
		equipmentRentQueryDAO.updateEquipmentInfo(equipmentRents);
	}


	public Page queryEquipmentRent(String name, String statue,int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		if("none".equals(name)){
			name="";
		}
		if("none".equals(statue)){
			statue="";
		}
		int totalRecord = equipmentRentQueryDAO.getQueryTotalRecord();
		Page page = new Page( pageNum,pageSize, totalRecord);
		List<EquipmentRentQuery> list = equipmentRentQueryDAO.queryEquipmentRent(name, statue,page.getStartIndex(),pageSize);
		page.setList(list);
		return page;
		}

	public Page getAllEquipmentChargePageData(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		int totalRecord = equipmentChargeDAO.getTotalRecord();
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<EquipmentCharge> list = equipmentChargeDAO.getAllEquipmentChargePageData(page.getStartIndex(), 
				pageSize);
		page.setList(list);
		return page;
	}


	public void setEquipmentCharge(EquipmentCharge equipmentCharge) {
		// TODO Auto-generated method stub
		equipmentChargeDAO.setEquipmentCharge(equipmentCharge);
	}

	public void deleteEquipmentCharge(int id) {
		// TODO Auto-generated method stub
		equipmentChargeDAO.deleteEquipmentCharge(id);
	}

	public List<EquipmentCharge> getAllEquipmentCharge() {
		// TODO Auto-generated method stub
		return equipmentChargeDAO.getAllEquipmentCharge();

	}

	public void updateEquipmentCharge(EquipmentCharge equipmentCharge) {
		// TODO Auto-generated method stub
		equipmentChargeDAO.updateEquipmentCharge(equipmentCharge);
	}

	public Page queryEquipmentCharge(String type, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		if("none".equals(type)){
			type="";
		}
		int totalRecord = equipmentChargeDAO.getQueryTotalRecord(type);
		Page page = new Page( pageNum,pageSize, totalRecord);
		List<EquipmentCharge> list = equipmentChargeDAO.queryEquipmentCharge(type,page.getStartIndex(),pageSize);
		page.setList(list);
		return page;
	}


	


	}
	
  

	

