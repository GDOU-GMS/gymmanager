package com.gms.web.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gms.domain.Page;
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
	private boolean flag;
	private int pageNum = 1;
	private int numPerPage = 20;// �൱��pagesize
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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

	/**
	 * 获得所有用户
	 * 
	 * @return
	 */
	public String getAllUsers() {
		// try{
		// map=new HashMap<String,Object>();
		// UserBusinessServiceImpl service=new UserBusinessServiceImpl();
		// listUsers=service.getAllUsers();
		// return "success";
		// }catch(Exception e){
		// e.printStackTrace();
		// return "error";
		// }
		try {
			UserBusinessServiceImpl service = new UserBusinessServiceImpl();
			Page page = service.getAllUsersPageDate(pageNum, numPerPage);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败", "", "", "");
			return "message";
		}
	}

	/**
	 * 条件查询获得用户
	 * 
	 * @return
	 */
	public String getUsers() {
		try {
			map = new HashMap<String, Object>();
			if (studentNo == null) {
				studentNo = "";
			}
			if (name == null) {
				name = "";
			}
			if (academy == null) {
				academy = "";
			}
			// UserBusinessServiceImpl service=new UserBusinessServiceImpl();
			// listUsers=service.getUsers(studentNo, name, academy);
			// return "success";
			// }catch(Exception e){
			// e.printStackTrace();
			// return "error";
			// }
			UserBusinessServiceImpl service = new UserBusinessServiceImpl();
			Page page = service.getUsersPageDate(pageNum, numPerPage,
					studentNo, name, academy);
			ActionContext.getContext().put("page", page);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "查询失败", "", "", "");
			return "message";
		}

	}

	/**
	 * 删除用户
	 * 
	 * @return
	 * @throws IOException
	 */
	public String deleteUser() throws IOException {

		// HttpServletResponse response=ServletActionContext.getResponse();
		// PrintWriter out = response.getWriter();
		try {
			ActionContext ctx = ActionContext.getContext();
			UserBusinessServiceImpl service = new UserBusinessServiceImpl();
			boolean flag = service.deleteUser(id);
			message = JSONTools.getJSONString("200", "删除成功", "getAllUsers", "",
					"");
		} catch (Exception e) {
			e.printStackTrace();
			message = JSONTools.getJSONString("300", "删除失败", "", "", "");
		}
		return "message";

	}

	/**
	 * 更新用户
	 * 
	 * @return
	 */
	public String updateUser() {
		try {
			UserBusinessServiceImpl userBusinessServiceImpl = new UserBusinessServiceImpl();
			userBusinessServiceImpl.updateUser(user);
			message = JSONTools.getJSONString("200", "更新成功", "getUsers",
					"closeCurrent", "");

		} catch (Exception e) {

			message = JSONTools.getJSONString("300", "更新失败", "", "", "");

		}
		return "message";

	}

	/**
	 * 更新用户密码
	 * 
	 * @return
	 */
	public String updatePassword() {
		try {
			UserBusinessServiceImpl userBusinessServiceImpl = new UserBusinessServiceImpl();
			userBusinessServiceImpl.updateUser(user);
			if (flag) {
				message = JSONTools.getJSONString("200", "密码修改成功", "", "", "");
			} else {
				message = JSONTools.getJSONString("300", "密码修改失败", "", "", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "message";

	}

	/**
	 * 根据登陆的id获得用户自己的信息
	 * 
	 * @return
	 */
	public String getUserSelf() {
		try {
			User user = (User) ActionContext.getContext().getSession()
					.get("user");
			if (user == null) {
				String path = ServletActionContext.getRequest()
						.getContextPath() + "/useraction/getUserSelf.action";
				ActionContext.getContext().put("path", path);
				return "unlogin";
			} else {
				user = (User) ActionContext.getContext().getSession()
						.get("user");
				UserBusinessServiceImpl userBusinessServiceImpl = new UserBusinessServiceImpl();
				user = userBusinessServiceImpl.getUserById(user.getId());
				return "success";
			}
		} catch (Exception e) {
			return "error";
		}
	}

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	public String clientLogin() {
		try {
			UserBusinessServiceImpl service = new UserBusinessServiceImpl();
			user = service.checkLogin(user.getStudentNo(), user.getPassword());
			if (user == null) {
				message = "您输入的账号密码有误，请重新登录";
				ActionContext.getContext().put("message", message);
				return "loginFaile";
			} else {

				ActionContext.getContext().getSession().put("user", user);
				if (path != null) {
					// 重定向
					HttpServletResponse response = ServletActionContext
							.getResponse();
					response.sendRedirect(path);
					// 重定向后,别忘了返回null值,而不能再返回return
					// mapping.findForward("****");
					return null;
				} else {
					return "success";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "不好意思，系统异常，我们会尽快维护的！";
			return "error";
		}
	}

	/**
	 * 退出登录
	 * 
	 * @return
	 */
	public String logout() {
		try {
			ActionContext.getContext().getSession().remove("user");
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = "不好意思，系统异常，我们会尽快维护的！";
			return "error";
		}
	}

	/**
	 * 用户更新个人信息
	 * 
	 * @return
	 */
	public String clientUpdateUser() {
		try {
			UserBusinessServiceImpl service = new UserBusinessServiceImpl();
			service.updateUser(user);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = "不好意思，系统异常，我们会尽快维护的！";
			return "error";
		}
	}

	/**
	 * 用户修改密码之前判断是否登录
	 * 
	 * @return
	 */
	public String checkBeforeUpdatePassword() {
		try {
			User user = (User) ActionContext.getContext().getSession()
					.get("user");
			if (user == null) {
				String path = ServletActionContext.getRequest()
						.getContextPath()
						+ "/useraction/checkBeforeUpdatePassword.action";
				ActionContext.getContext().put("path", path);
				return "unlogin";
			} else {
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "不好意思，系统异常，我们会尽快维护的！";
			return "error";
		}
	}

	/**
	 * 用户修改密码
	 * 
	 * @return
	 */
	public String clientUpdatePassword() {
		try {
			UserBusinessServiceImpl service = new UserBusinessServiceImpl();
			service.updatePassword(user.getId(), user.getPassword());
			ActionContext.getContext().put("message", "修改密码成功！");
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			message = "不好意思，系统异常，我们会尽快维护的！";
			return "error";
		}
	}

}
