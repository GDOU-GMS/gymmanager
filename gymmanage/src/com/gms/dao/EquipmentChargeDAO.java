package com.gms.dao;

import java.util.List;

import com.gms.domain.EquipmentCharge;
public interface EquipmentChargeDAO {

	 /**
	  * ���������Ϣ�շѱ�׼��¼
	  * @param startIndex
	  * @param pageSize
	  * @return
	  */
	 public List<EquipmentCharge> getAllEquipmentChargePageData(int startIndex,
				int pageSize);
	 
	 /**
	  * ���������շѱ�׼
	  */
     public abstract void setEquipmentCharge(EquipmentCharge equipmentCharge);
     
     /**
      * ɾ�������շѱ�׼��Ϣ
      * @param id
      */
     public abstract void deleteEquipmentCharge(int id);
     
     public abstract void updateEquipmentCharge(EquipmentCharge equipmentCharge); 
     
     /**
      * �õ������շѱ�׼�ܼ�¼��
      * @return
      */
 	 public abstract int getTotalRecord();
 	 
 	 /**
 	  * ��ѯ�����շѱ�׼
 	  */
 	 public abstract List<EquipmentCharge> queryEquipmentCharge(String type,int startIndex,int pageSize);
 	 
 	 /**
 	  * ����շѱ�׼��ѯ��¼��
 	  * @return
 	  */
 	 public abstract int getQueryTotalRecord(String type);

 	 /**
 	  * ��������շѱ�׼��Ϣ
 	  * @return
 	  */
	public List<EquipmentCharge> getAllEquipmentCharge();
}