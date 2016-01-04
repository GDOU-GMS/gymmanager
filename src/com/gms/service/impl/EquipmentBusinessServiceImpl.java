package com.gms.service.impl;

import java.util.List;

import com.gms.dao.EquipmentChargeDAO;
import com.gms.dao.EquipmentDAO;
import com.gms.dao.EquipmentRentQueryDAO;
import com.gms.dao.EquipmentTypeDAO;
import com.gms.domain.Equipment;
import com.gms.domain.EquipmentRentQuery;
import com.gms.domain.EquipmentCharge;
import com.gms.domain.EquipmentType;
import com.gms.domain.Page;
import com.gms.domain.SiteType;
import com.gms.factory.DAOFactory;

public class EquipmentBusinessServiceImpl {

	DAOFactory daoFactory = DAOFactory.getInstance();
	private EquipmentDAO equipmentDAO = daoFactory.createDAO("com.gms.dao.impl.EquipmentDAOImpl");
	private EquipmentRentQueryDAO equipmentRentQueryDAO = daoFactory.createDAO("com.gms.dao.impl.EquipmentRentQueryDAOImpl");
    private EquipmentChargeDAO equipmentChargeDAO=daoFactory.createDAO("com.gms.dao.impl.EquipmentChargeDAOImpl");
    private EquipmentTypeDAO equipmentTypeDAO=daoFactory.createDAO("com.gms.dao.impl.EquipmentTypeDAOImpl");

	
    /**
	 * 添加场地类型
	 * @param siteType
	 */
	public void addEquipmentType(EquipmentType equipmentType){
		equipmentTypeDAO.addType(equipmentType);
	}
	/**
	 * 更新场地类型
	 * @param siteType
	 */
	public void updateEquipmentType(EquipmentType equipmentType){
		equipmentTypeDAO.updateType(equipmentType);
	}
	/**
	 * 删除场地类型
	 * @param id
	 */
	public void deleteEquipmentType(int id){
		equipmentTypeDAO.deleteType(id);
	}
	/**
	 * 获取所有场地的类型
	 */
	public List<EquipmentType> getAllEquipmentType(){
		return equipmentTypeDAO.getAllEquipmentType();
	}
	
	/**
	 * 根据id查找场地
	 * @param id
	 * @return
	 */
	public EquipmentType getEquipmentTypeById(int id){
		return equipmentTypeDAO.getEquipmentTypeById(id);
	}

	/**
	 * 判断该器材类型是否被使用
	 * @param typeId
	 * @return
	 */
	public int checkEquipmentTypeIsUsed(int typeId){
		return equipmentTypeDAO.checkEquipmentTypeIsUsed(typeId);
	}
	
	/**
	 * 根据id查询
	 * @param id
	 * @return 
	 * @return
	 */
	public  EquipmentCharge getEquipmentChargeById(int id){
		return equipmentChargeDAO.getEquipmentChargeById(id);
	}
	
	/**
	 * 更新租赁信息
	 * @param equipmentRents
	 */
	public void updateEquipRentInfo( EquipmentRentQuery equipmentRents){
		equipmentRentQueryDAO.updateEquipRentInfo(equipmentRents);
	}
	
    
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
		equipmentDAO.addEquipment(equipment);
	}
	
	/**
	 * 根据id查找器材
	 * @param id
	 * @return
	 */
	public  Equipment getEquipmentById(int id){
		return equipmentDAO.getEquipmentById(id);
	}
     /**
      * 更新器材
      * @param equipment
      */
	public void updateEquipment(Equipment equipment) {
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
		int totalRecord = equipmentDAO.getQueryTotalRecord(type);
		Page page = new Page( pageSize,pageNum, totalRecord);
		List<Equipment> list = equipmentDAO.queryEquipment(type, page.getStartIndex(),pageSize);
		page.setList(list);
		return page;
	}

	public void addEquipRentInfo(EquipmentRentQuery equipmentRents) {
		equipmentRentQueryDAO.addEquipRentInfo(equipmentRents);
	}

	public void deleteEquipmentInfo(int id) {
		equipmentRentQueryDAO.deleteEquipmentInfo(id);
	}
	
	public void updateEquipmentInfo(EquipmentRentQuery equipmentRents) {
		equipmentRentQueryDAO.updateEquipmentInfo(equipmentRents);
	}


	public Page queryEquipmentRent(String name, String statue,int pageNum, int pageSize) {
		if("none".equals(statue)){
			statue="";
		}
		int totalRecord = equipmentRentQueryDAO.getQueryTotalRecord( name,  statue);
		Page page = new Page( pageSize,pageNum, totalRecord);
		List<EquipmentRentQuery> list = equipmentRentQueryDAO.queryEquipmentRent(name, statue,page.getStartIndex(),pageSize);
		page.setList(list);
		return page;
		}

	public Page getAllEquipmentChargePageData(int pageNum, int pageSize) {
		int totalRecord = equipmentChargeDAO.getTotalRecord();
		Page page = new Page(pageSize, pageNum, totalRecord);
		List<EquipmentCharge> list = equipmentChargeDAO.getAllEquipmentChargePageData(page.getStartIndex(), 
				pageSize);
		page.setList(list);
		return page;
	}


	public void setEquipmentCharge(EquipmentCharge equipmentCharge) {
		equipmentChargeDAO.setEquipmentCharge(equipmentCharge);
	}

	public void deleteEquipmentCharge(int id) {
		equipmentChargeDAO.deleteEquipmentCharge(id);
	}

	public List<EquipmentCharge> getAllEquipmentCharge() {
		return equipmentChargeDAO.getAllEquipmentCharge();

	}

	public void updateEquipmentCharge(EquipmentCharge equipmentCharge) {
		equipmentChargeDAO.updateEquipmentCharge(equipmentCharge);
	}

	public Page queryEquipmentCharge(String type, int pageNum, int pageSize) {
		int totalRecord = equipmentChargeDAO.getQueryTotalRecord(type);
		Page page = new Page( pageSize, pageNum,totalRecord);
		List<EquipmentCharge> list = equipmentChargeDAO.queryEquipmentCharge(type,page.getStartIndex(),pageSize);
		page.setList(list);
		return page;
	}


	/**
	 * 根据id查找器材租赁
	 * @param id
	 * @return
	 */
	public EquipmentRentQuery getEquipmentRentQueryById(int id ){
		return equipmentRentQueryDAO.getEquipmentRentQueryById(id);
	}
	
	/**
	 * 租赁出去，更新可供借出
	 * @param num
	 * @param id
	 */
	public void updateEquipmentLoanable(int num, int id){
		equipmentDAO.updateEquipmentLoanable(num, id);
	}
	/**
	 * 器材归还更细可供借出
	 * @param num
	 * @param id
	 */
	public void recoverLoanable(int num,int id){
		equipmentDAO.recoverLoanable(num, id);
	}

	
	/**
	 * 删除器材租赁
	 * @param id
	 */
	public void deleteEquipmentRentQuery(int id){
		equipmentRentQueryDAO.deleteEquipmentRentQuery(id);
	}
	/**
	 * 处理过期的租赁
	 */
	public int dealpassedEquipRent(){
		return equipmentRentQueryDAO.dealpassedEquipRent();
	}
}
	

