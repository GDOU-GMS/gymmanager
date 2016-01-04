package com.gms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gms.domain.Manager;

public class CheckManagerLoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		Manager manager = (Manager) request.getSession().getAttribute("manager");
		
		
		/**
		 * û�е�¼����ת��ָ��
		 */
		if(manager==null){
			//request.setAttribute("message", "���ȵ�¼��");
			request.getRequestDispatcher("/manager_login.jsp").forward(request, response);
			//response.sendRedirect("manager_login.jsp");
			return;
		}else{
			
			arg2.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
