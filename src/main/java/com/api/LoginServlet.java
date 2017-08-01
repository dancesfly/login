package com.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");  
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();  
		
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("password")); 
		
		if(request.getSession().getAttribute("user") != null) {
			out.write(user.getName() + ":已经登录");
		}
		else{
			out.write(user.getName() + ":登录成功");
		}
		
		if(user.getName() != null && user.getPassword() != null) {
			request.getSession().setAttribute("user", user);
		}
		
		out.write("<a href=\"logout\">退出登录</a>");
	}
}
