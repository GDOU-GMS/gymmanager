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
	 * ��ӳ�������
	 * @param siteType
	 */
	public void addEquipmentType(EquipmentType equipmentType){
		equipmentTypeDAO.addType(equipmentType);
	}
	/**
	 * ���³�������
	 * @param siteType
	 */
	public void updateEquipmentType(EquipmentType equipmentType){
		equipmentTypeDAO.updateType(equipmentType);
	}
	/**
	 * ɾ����������
	 * @param id
	 */
	public void deleteEquipmentType(int id){
		equipmentTypeDAO.deleteType(id);
	}
	/**
	 * ��ȡ���г��ص�����
	 */
	public List<EquipmentType> getAllEquipmentType(){
		return equipmentTypeDAO.getAllEquipmentType();
	}
	
	/**
	 * ����id���ҳ���
	 * @param id
	 * @return
	 */
	public EquipmentType getEquipmentTypeById(int id){
		return equipmentTypeDAO.getEquipmentTypeById(id);
	}

	/**
	 * �жϸ����������Ƿ�ʹ��
	 * @param typeId
	 * @return
	 */
	public int checkEquipmentTypeIsUsed(int typeId){
		return equipmentTypeDAO.checkEquipmentTypeIsUsed(typeId);
	}
	
	/**
	 * ����id��ѯ
	 * @param id
	 * @return 
	 * @return
	 */
	public  EquipmentCharge getEquipmentChargeById(int id){
		return equipmentChargeDAO.getEquipmentChargeById(id);
	}
	
	/**
	 * ����������Ϣ
	 * @param equipmentRents
	 */
	public void updateEquipRentInfo( EquipmentRentQuery equipmentRents){
		equipmentRentQueryDAO.updateEquipRentInfo(equipmentRents);
	}
	
    
	/**
	 * ������Ϣ
	 * @return
	 */
	public List<Equipment> getAllEquipment() {
		return equipmentDAO.getAllEquipment();
	}

  /**
   * �������
   * @param equipment
   */
	public void addEquipment(Equipment equipment) {
		equipmentDAO.addEquipment(equipment);
	}
	
	/**
	 * ����id��������
	 * @param id
	 * @return
	 */
	public  Equipment getEquipmentById(int id){
		return equipmentDAO.getEquipmentById(id);
	}
     /**
      * ��������
      * @param equipment
      */
	public void updateEquipment(Equipment equipment) {
		equipmentDAO.updateEquipment(equipment);
		
	}
     /**
      * ���������Ϣ
      * @return
      */
	public List<EquipmentRentQuery> getAllEquipmentRent() {
		// TODO Auto-generated method stub
		return equipmentRentQueryDAO.getAllEquipmentRent();
	}
	
	/**
	 * ���������Ϣ��ҳ����
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
	  * ɾ������
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
	 * ����id������������
	 * @param id
	 * @return
	 */
	public EquipmentRentQuery getEquipmentRentQueryById(int id ){
		return equipmentRentQueryDAO.getEquipmentRentQueryById(id);
	}
	
	/**
	 * ���޳�ȥ�����¿ɹ����
	 * @param num
	 * @param id
	 */
	public void updateEquipmentLoanable(int num, int id){
		equipmentDAO.updateEquipmentLoanable(num, id);
	}
	/**
	 * ���Ĺ黹��ϸ�ɹ����
	 * @param num
	 * @param id
	 */
	public void recoverLoanable(int num,int id){
		equipmentDAO.recoverLoanable(num, id);
	}

	
	/**
	 * ɾ����������
	 * @param id
	 */
	public void deleteEquipmentRentQuery(int id){
		equipmentRentQueryDAO.deleteEquipmentRentQuery(id);
	}
	/**
	 * ������ڵ�����
	 */
	public int dealpassedEquipRent(){
		return equipmentRentQueryDAO.dealpassedEquipRent();
	}
}
	

