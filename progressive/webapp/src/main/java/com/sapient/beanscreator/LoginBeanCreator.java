package com.sapient.beanscreator;

import javax.servlet.http.HttpServletRequest;

import com.sapient.beans.LoginBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginBeanCreator {
	private LoginBeanCreator() {

	}
	public static LoginBean createLoginBean(HttpServletRequest request) {
		LoginBean loginBean = new LoginBean();
		loginBean.setEmail(request.getParameter("email"));
		loginBean.setPassword(request.getParameter("password"));
		return loginBean;
	}
	
}
