package com.gms.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gms.domain.User;
import com.gms.service.impl.UserBusinessServiceImpl;
import com.gms.utils.JSONTools;
import com.opensymphony.xwork2.ActionContext;

public class UserAction {
	private int id;
	private String studentNo;
	private String name;
	private String academy;
	private User user;
	private Map map;
	private List<User> listUsers;
	private String message;
	public List<User> getListUsers() {
		return listUsers;
	}
	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getAcademy() {
		return academy;
	}
	public void setAcademy(String academy) {
		this.academy = academy;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	 public String  getAllUsers(){
	    	try{
	    	map=new HashMap<String,Object>();
	    	UserBusinessServiceImpl service=new UserBusinessServiceImpl();
	    	listUsers=service.getAllUsers();
	    	return "success";
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		return "error";
	    	}
			
	    }
	
	
    public String  getUsers(){
    	try{
    	map=new HashMap<String,Object>();
    	if(studentNo==null){
    		studentNo="";
    	}
    	if(name==null){
    		name="";
    	}
    	if(academy==null){
    		academy="";
    	}
    	UserBusinessServiceImpl service=new UserBusinessServiceImpl();
    	listUsers=service.getUsers(studentNo, name, academy);
    	return "success";
    	}catch(Exception e){
    		e.printStackTrace();
    		return "error";
    	}
		
    }
    public String deleteUser() throws IOException{
    
//    	 HttpServletResponse response=ServletActionContext.getResponse();
//    	 PrintWriter out = response.getWriter(); 
    	try{
    		ActionContext ctx = ActionContext.getContext();
	    	UserBusinessServiceImpl service=new UserBusinessServiceImpl();
	    	boolean flag=service.deleteUser(id);
	    	message = JSONTools.getJSONString("200", "删除成功", "getAllUsers","", "");
    	}catch(Exception e){
    		e.printStackTrace();
			message = JSONTools.getJSONString("300", "删除失败","", "", "");
    	}
    	return "message";
    
    }
	

}
