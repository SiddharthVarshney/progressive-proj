package com.sapient.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sapient.beans.LoginBean;
import com.sapient.beanscreator.LoginBeanCreator;
import com.sapient.services.LoginService;

/**
 * Servlet implementation class LoginBeanController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		
		LoginBean logBean = LoginBeanCreator.createLoginBean(req);
		LoginBean registered = new LoginService().loginValidate(logBean); 
		if( registered != null && logBean.getEmail()!=null && logBean.getPassword()!=null) {
			String name = registered.getName();
//			Cookie cookie = new Cookie("username", name);
//			resp.addCookie(cookie);
//			Cookie cookie_ = new Cookie("userid", registered.getId().toString());
//			resp.addCookie(cookie_);
//			
			
			resp.getWriter().println("<div class=\"alert alert-primary\" role=\"alert\">\r\n"
					+ "  LOGIN SUCCESS \r\n"
					+ "</div>");
			
			
			HttpSession session = req.getSession(false);
			session.setAttribute("userId",registered.getId());
			
		}
		else {
			resp.getWriter().println("<div class=\"alert alert-primary\" role=\"alert\">\r\n"
					+ " LOGIN FAILED \r\n"
					+ "</div>");
		}
		resp.sendRedirect("home");
	}

}
