package com.sapient.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.beans.LoginBean;
import com.sapient.beanscreator.LoginBeanCreator;
import com.sapient.service.LoginService;

/**
 * Servlet implementation class LoginBeanController
 */
@WebServlet("/login")
public class LoginBeanController extends HttpServlet {
	
    public LoginBeanController() {
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
		
		if( new LoginService().registrationValidate(logBean)) {
			
			resp.getWriter().println("<div class=\"alert alert-primary\" role=\"alert\">\r\n"
					+ "  LOGIN SUCCESS \r\n"
					+ "</div>");
		}
		else {
			resp.getWriter().println("<div class=\"alert alert-primary\" role=\"alert\">\r\n"
					+ " LOGIN FAILED \r\n"
					+ "</div>");
		}
		req.getRequestDispatcher("index.jsp").include(req, resp);
	}

}
