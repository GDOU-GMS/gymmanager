package com.gms.web.action;

import java.util.List;

import com.gms.domain.Equipment;
import com.gms.domain.EquipmentCharge;
import com.gms.domain.EquipmentRentQuery;
import com.gms.domain.Page;
import com.gms.domain.SiteType;
import com.gms.service.impl.EquipmentBusinessServiceImpl;
import com.gms.service.impl.SiteBusinessServiceImpl;
import com.gms.utils.JSONTools;
import com.opensymphony.xwork2.ActionContext;

public class EquipmentAction {

	private String message;
	private Equipment equipment;
	private List<Equipment> equipments;
	private EquipmentRentQuery equipmentRents;
	private EquipmentCharge equipmentCharge;
	private int id;	
	private int userId;
	private int totalNum;
	private String type;

	private String name;
	private String description;
	private float feeScale;
	private int pageNum = 1;
	private int numPerPage = 20;
	private String statue;
	public String getStatue() {
		return statue;
	}
	public void setStatue(String statue) {
		this.statue = statue;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public List<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	
	public EquipmentRentQuery getEquipmentRents() {
		return equipmentRents;
	}
	public void setEquipmentRents(EquipmentRentQuery equipmentRents) {
		this.equipmentRents = equipmentRents;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public EquipmentCharge getEquipmentCharge() {
		return equipmentCharge;
	}
	public void setEquipmentCharge(EquipmentCharge equipmentCharge) {
		this.equipmentCharge = equipmentCharge;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * 娣诲姞鍣ㄦ潗
	 * @param equipment
	 * @return
	 */
	public String addEquipment()
	{
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			service.addEquipment(equipment);
			message = JSONTools.getJSONString("200", "添加成功", "getAllEquipment",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "添加失败", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 所有器材信息
	 * @return
	 */
	public String getAllEquipment(){
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			Page page = service.getAllEquipmentPageData(pageNum, numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
			
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "刷新失败", "", "", "");
			return "message";
		}
	}
	
	public String deleteEquipment(){
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			service.deleteEquipment(id);
			message = JSONTools.getJSONString("200", "删除成功", "getAllEquipment",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "删除失败", "", "", "");
		}
		return "message";
		
	}
	
    public String updateEquipment(){
   	 
   	 try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			service.updateEquipment(equipment);
			message = JSONTools.getJSONString("200", "更新成功", "getAllEquipment",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "更新失败", "", "", "");
		}
		return "message";
    }
	
	
	public String getDataForaddEquipment() {
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			List<Equipment> equipments = service.getAllEquipment();
			ActionContext.getContext().put("equipments", equipments);	
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "澶辫触", "", "", "");
			return "message";
		}
	}
	/**
	 * 器材租借信息
	 * @return
	 */
	
	public String getAllEquipmentRent(){
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			Page page = service.getAllEquipmentRentQueryPageData(pageNum, numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败!", "", "", "");
			return "message";
		}
		
	}
	
	
	public String queryEquipment(){
		
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			List<Equipment> equipments = service.getAllEquipment();
			ActionContext.getContext().put("equipments", equipments);
			Page page = service.queryEquipment(name, pageNum,numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return "message";
		}
	}
	
	public String getDataForaddequipRentQuery(){
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			List<EquipmentRentQuery> equipments = service.getAllEquipmentRent();
			ActionContext.getContext().put("equipments", equipments);	
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "打开失败", "", "", "");
			return "message";
		}
		
	}
	
	public String addEquipRentInfo(){
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			service.addEquipRentInfo(equipmentRents);
			message = JSONTools.getJSONString("200", "添加成功", "getAllEquipment",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "添加失败", "", "", "");
		}
		return "message";
	}
	
	public String deleteEquipmentInfo(){
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			service.deleteEquipmentInfo(id);
			message = JSONTools.getJSONString("200", "删除成功", "getAllEquipmentRent",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "删除失败", "", "", "");
		}
		return "message";
	}
	
	
	public String updateEquipmentInfo(){
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			service.updateEquipmentInfo(equipmentRents);
			message = JSONTools.getJSONString("200", "更新成功", "getAllEquipmentRent",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "更新失败", "", "", "");
		}
		return "message";
		
	}
	
	public String queryEquipmentRent(){
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			List<EquipmentRentQuery> equipmentRents = service.getAllEquipmentRent();
			ActionContext.getContext().put("equipmentRents", equipmentRents);
			Page page = service.queryEquipmentRent(name,statue, pageNum,numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return "message";
		}
	}
	
      public String getAllEquipmentCharge(){
    		try {
    			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
    			Page page = service.getAllEquipmentChargePageData(pageNum, numPerPage);
    			ActionContext.getContext().put("page", page);
    			return "success";
    		} catch (Exception e) {
    			e.printStackTrace();
    			message = JSONTools.getJSONString("300", "查询失败!", "", "", "");
    			return "message";
    		}
    	  
      }
      
      public String setEquipmentCharge(){
    	  try {
  			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
  			service.setEquipmentCharge(equipmentCharge);
  			message = JSONTools.getJSONString("200", "添加成功", "getAllEquipmentCharge",
  					"closeCurrent", "");
  		} catch (Exception e) {
  			e.printStackTrace();
  			message = JSONTools.getJSONString("300", "添加失败", "", "", "");
  		}
  		return "message";
    	  
      }
      
      public String getDataForsetEquipmentCharge(){
    	  try {
  			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
  			List<EquipmentCharge> equipmentcharges = service.getAllEquipmentCharge();
  			ActionContext.getContext().put("equipmentcharges", equipmentcharges);	
  			return "success";
  		} catch (Exception e) {
  			e.printStackTrace();
  			message = JSONTools.getJSONString("300", "澶辫触", "", "", "");
  			return "message";
  		}
    	  
      }
      
      
     public String deleteEquipmentCharge(){
    		try {
    			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
    			service.deleteEquipmentCharge(id);
    			message = JSONTools.getJSONString("200", "删除成功", "getAllEquipmentCharge",
    					"closeCurrent", "");
    		} catch (Exception e) {
    			e.printStackTrace();
    			message = JSONTools.getJSONString("300", "删除失败", "", "", "");
    		}
    		return "message";
    	 
     }
     
     public String updateEquipmentCharge(){
    		try {
    			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
    			service.updateEquipmentCharge(equipmentCharge);
    			message = JSONTools.getJSONString("200", "更新成功！", "getAllEquipmentCharge",
    					"closeCurrent", "");
    		} catch (Exception e) {
    			message = JSONTools.getJSONString("300", "更新失败，系统异常！", "", "", "");
    		}
    		return "message";
     }
     
    public String queryEquipmentCharge(){
    	try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			List<EquipmentCharge> equipmentCharge = service.getAllEquipmentCharge();
			ActionContext.getContext().put("equipmentCharge", equipmentCharge);
			Page page = service.queryEquipmentCharge(type, pageNum,numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return "message";
		}
    	
    }
}
