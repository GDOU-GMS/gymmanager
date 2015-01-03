package com.gms.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.gms.domain.Equipment;
import com.gms.domain.EquipmentCharge;
import com.gms.domain.EquipmentRentQuery;
import com.gms.domain.EquipmentType;
import com.gms.domain.Page;
import com.gms.domain.Site;
import com.gms.domain.SiteType;
import com.gms.domain.User;
import com.gms.service.impl.EquipmentBusinessServiceImpl;
import com.gms.service.impl.SiteBusinessServiceImpl;
import com.gms.service.impl.UserBusinessServiceImpl;
import com.gms.utils.JDBCUtils;
import com.gms.utils.JSONTools;
import com.opensymphony.xwork2.ActionContext;

public class EquipmentAction {

	private String message;
	private Equipment equipment;
	private List<Equipment> equipments;
	private EquipmentRentQuery equipmentRents;
	private EquipmentCharge equipmentCharge;
	private EquipmentType equipmentType;
	private int id;	
	private int userId;
	private int totalNum;
	private String type;
	private int oldNum;

	private String name;
	private String description;
	private float feeScale;
	private int pageNum = 1;
	private int numPerPage = 20;
	private String statue;
	
	
	public int getOldNum() {
		return oldNum;
	}
	public void setOldNum(int oldNum) {
		this.oldNum = oldNum;
	}
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

	

	public EquipmentType getEquipmentType() {
		return equipmentType;
	}
	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}
	/**
	 * 添加场地类型
	 * 
	 * @return
	 */
	public String addEquipmentType() {
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			service.addEquipmentType(equipmentType);
			message = JSONTools.getJSONString("200", "添加成功！", "getAllEquipmentType",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "添加失败，系统异常！", "", "", "");
		}
		return "message";
	}

	/**
	 * 获得所有的场地类型
	 * 
	 * @return
	 */
	public String getAllEquipmentType() {
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			List<EquipmentType> equipmentTypes = service.getAllEquipmentType();
			ActionContext.getContext().put("equipmentTypes", equipmentTypes);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常!", "", "", "");
			return "message";
		}
	}

	/**
	 * 删除场地类型
	 * 
	 * @return
	 * @throws IOException
	 */
	public String deleteEquipmentType() {
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			int count = service.checkEquipmentTypeIsUsed(id);
			if(count>0){
				message = JSONTools.getJSONString("300", "删除失败，该场地类型正在被场地使用中！", "", "", "");
				return "message";
			}
			service.deleteEquipmentType(id);
			message = JSONTools.getJSONString("200", "删除成功！", "getAllEquipmentType",
					"", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "删除失败，系统异常",
					"", "", "");
		}
		return "message";
	}

	/**
	 * 
	 * 获得回显数据，修改
	 * 
	 * @return
	 */
	public String getDataForUpdateEquipmentType() {
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			EquipmentType equipmentType = service.getEquipmentTypeById(id);
			ActionContext.getContext().put("equipmentType", equipmentType);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return "message";
		}
	}

	/**
	 * 更新器材类型
	 * 
	 * @return
	 */
	public String updateEquipmentType() {
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			service.updateEquipmentType(equipmentType);
			message = JSONTools.getJSONString("200", "更新成功！", "getAllEquipmentType",
					"closeCurrent", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "更新失败，系统异常！", "", "", "");
		}
		return "message";
	}
	
/*******************************************************************************************
 * 										以上是seven增加代码
 * *****************************************************************************************/
	/**
	 * 娣诲姞鍣ㄦ潗
	 * @param equipment
	 * @return
	 */
	public String addEquipment()
	{
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			equipment.setLoanable(equipment.getTotalNum()-equipment.getUnderRepair());
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
					"", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "删除失败", "", "", "");
		}
		return "message";
		
	}
	
	/**
	 * 更新器材之前获得回显数据
	 * @return
	 */
	public String getDateForUpdateEquipment(){
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			List<EquipmentType> EquipmentTypes = service.getAllEquipmentType();
			ActionContext.getContext().put("EquipmentTypes", EquipmentTypes);	
			Equipment equipment = service.getEquipmentById(id);
			ActionContext.getContext().put("equipment", equipment);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "系统异常！", "", "", "");
			return "message";
		}
	}
	
    public String updateEquipment(){
   	 try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			equipment.setLoanable(equipment.getTotalNum()-equipment.getUnderRepair());
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
			List<EquipmentType> EquipmentTypes = service.getAllEquipmentType();
			ActionContext.getContext().put("EquipmentTypes", EquipmentTypes);	
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
	
	
	/**
	 * 查询器材
	 * @return
	 */
	public String queryEquipment(){
		
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			System.out.println(equipment.getName());
			Page page = service.queryEquipment(equipment.getName(), pageNum,numPerPage);
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
			List<EquipmentType> EquipmentTypes = service.getAllEquipmentType();
			ActionContext.getContext().put("EquipmentTypes", EquipmentTypes);	
			List<Equipment> equipments = service.getAllEquipment();
			ActionContext.getContext().put("equipments", equipments);
			
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "打开失败", "", "", "");
			return "message";
		}
		
	}
	
	/**
	 * 添加器材租赁
	 * @return
	 */
	public String addEquipRentInfo(){
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			UserBusinessServiceImpl userService = new UserBusinessServiceImpl();
			//先找出学生
			User user = userService.getUserByStudentNo(equipmentRents.getStudentNo());
			if(user==null){
				message = JSONTools.getJSONString("300", "该用户不存在！", "", "", "");
				return "message";
			}
			//保存ID
			equipmentRents.setUserId(user.getId());
			//判断是否有足够的器材可供借出
			int equipmentId = equipmentRents.getEquipmentId();
			Equipment e = service.getEquipmentById(equipmentId);
			if(e.getLoanable()<equipmentRents.getNum()){
				message = JSONTools.getJSONString("300", "剩余器材不够！", "", "", "");
				return "message";
			}
			//计算天数
			int day = (int) ((equipmentRents.getEndDate().getTime()-equipmentRents.getStartDate().getTime())/(24*60*60*1000));
			//再计算价格
			EquipmentCharge ec = service.getEquipmentChargeById(e.getTypeId());
			float price = ec.getFeescale()*equipmentRents.getNum()*day;
			equipmentRents.setPrice(price);
			service.addEquipRentInfo(equipmentRents);
			//更新可供借出的数量
			service.updateEquipmentLoanable(equipmentRents.getNum(),equipmentRents.getEquipmentId());
			
			message = JSONTools.getJSONString("200", "添加成功", "getAllEquipmentRent",
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
	
	/**
	 * 获得更新租赁回想数据
	 * @return
	 */
	public String getDateForupdateEquipRent(){
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			List<EquipmentType> EquipmentTypes = service.getAllEquipmentType();
			ActionContext.getContext().put("EquipmentTypes", EquipmentTypes);	
			List<Equipment> equipments = service.getAllEquipment();
			ActionContext.getContext().put("equipments", equipments);
			EquipmentRentQuery erq = service.getEquipmentRentQueryById(id);
			if("passed".equals(erq.getStatue())){
				message = JSONTools.getJSONString("300", "该记录已经过期了，不给予修改！", "", "", "");
				return "message";
			}
			ActionContext.getContext().put("equipmentRents", erq);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "系统异常！", "", "", "");
			return "message";
		}
	}
	/**
	 * 更新租赁
	 * @return
	 */
	public String updateEquipRent(){
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			UserBusinessServiceImpl userService = new UserBusinessServiceImpl();
			//先找出学生
			User user = userService.getUserByStudentNo(equipmentRents.getStudentNo());
			if(user==null){
				message = JSONTools.getJSONString("300", "该用户不存在！", "", "", "");
				return "message";
			}
			//保存ID
			equipmentRents.setUserId(user.getId());
			//判断是否有足够的器材可供借出
			int equipmentId = equipmentRents.getEquipmentId();
			Equipment e = service.getEquipmentById(equipmentId);
			if(e.getLoanable()<equipmentRents.getNum()){
				message = JSONTools.getJSONString("300", "剩余器材不够！", "", "", "");
				return "message";
			}
			//计算天数
			int day = (int) ((equipmentRents.getEndDate().getTime()-equipmentRents.getStartDate().getTime())/(24*60*60*1000));
			//再计算价格
			EquipmentCharge ec = service.getEquipmentChargeById(e.getTypeId());
			float price = ec.getFeescale()*equipmentRents.getNum()*day;
			equipmentRents.setPrice(price);
			service.updateEquipRentInfo(equipmentRents);
			//更新可供借出的数量(注意此处需要得到之前的数据，与之前的数据比较)
			service.updateEquipmentLoanable(equipmentRents.getNum()-oldNum,equipmentRents.getEquipmentId());
			
			message = JSONTools.getJSONString("200", "修改成功", "getAllEquipmentRent",
					"", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "修改失败，系统异常!", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 归还器材
	 * @return
	 */
	public String recoverEquipRent(){
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			EquipmentRentQuery erq = service.getEquipmentRentQueryById(id);
			//更新可用的器材
			service.recoverLoanable(erq.getNum(), erq.getEquipmentId());
			//删除该租赁
			service.deleteEquipmentRentQuery(id);
			message = JSONTools.getJSONString("200", "归还成功", "getAllEquipmentRent","", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "操作失败，系统异常!", "", "", "");
		}
		return "message";
	}
	
	/**
	 * 处理过期预约
	 * @return
	 */
	public String dealpassedEquipRent(){
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			int count = service.dealpassedEquipRent();
			message = JSONTools.getJSONString("200", "处理成功,一共处理了"+count+"记录！", "getAllEquipmentRent","", "");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "操作失败，系统异常!", "", "", "");
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
	
	/**
	 * 查询场地租赁
	 * @return
	 */
	public String queryEquipmentRent(){
		try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			Page page = service.queryEquipmentRent(equipmentRents.getStudentNo(),equipmentRents.getStatue(), pageNum,numPerPage);
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
  			message = JSONTools.getJSONString("200", "设置成功", "getAllEquipmentCharge",
  					"closeCurrent", "");
  		} catch (Exception e) {
  			e.printStackTrace();
  			message = JSONTools.getJSONString("300", "设置失败，系统异常", "", "", "");
  		}
  		return "message";
    	  
      }
      
      /**
       * 更新前获取数据
       * @return
       */
      public String getDataForsetEquipmentCharge(){
    	  try {
  			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
  			EquipmentCharge equipmentCharge = service.getEquipmentChargeById(id);
  			ActionContext.getContext().put("equipmentCharge", equipmentCharge);	
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
    			int count = service.checkEquipmentTypeIsUsed(id);
    			if(count>0){
    				message = JSONTools.getJSONString("300", "删除失败，该场地类型正在被场地使用中！", "", "", "");
    				return "message";
    			}
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
     
     /**
      * 查询场地收费标准
      * @return
      */
    public String queryEquipmentCharge(){
    	try {
			EquipmentBusinessServiceImpl service = new EquipmentBusinessServiceImpl();
			Page page = service.queryEquipmentCharge(equipmentCharge.getType(), pageNum,numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败，系统异常！", "", "", "");
			return "message";
		}
    	
    }
}
