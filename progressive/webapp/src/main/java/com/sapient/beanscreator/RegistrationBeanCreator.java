package com.sapient.beanscreator;

import javax.servlet.http.HttpServletRequest;

import com.sapient.beans.RegistrationBean;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class RegistrationBeanCreator {
	private RegistrationBeanCreator() {

	}

	public static RegistrationBean createRegistrationBean(HttpServletRequest request) {
		RegistrationBean regBean = new RegistrationBean(0, request.getParameter("username"),
				request.getParameter("email"), request.getParameter("password"), request.getParameter("gender"),
				(double) 0, new Date());
		
		log.info("registration bean {}",regBean);
		return regBean;
	}
}
