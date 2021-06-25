package com.sapient.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.sapient.beans.RegistrationBean;
import com.sapient.beanscreator.RegistrationBeanCreator;
import com.sapient.service.RegistrationService;

@WebServlet("/register")
public class RegistrationBeanController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");


		
		RegistrationBean regBean = RegistrationBeanCreator.createRegistrationBean(req);
		if( new RegistrationService().registrationValidate(regBean)) {
			
			resp.getWriter().println("<div class=\"alert alert-primary\" role=\"alert\">\r\n"
					+ "  REGISTRATION SUCCESS \r\n"
					+ "</div>");
		}
		else {
			resp.getWriter().println("<div class=\"alert alert-primary\" role=\"alert\">\r\n"
					+ "  REGISTRATION FAILED \r\n"
					+ "</div>");
		}
		req.getRequestDispatcher("index.jsp").include(req, resp);


	}
}
