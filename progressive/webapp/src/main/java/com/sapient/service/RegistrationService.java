package com.sapient.service;

import com.sapient.beans.RegistrationBean;
import com.sapient.beans.User;
import com.sapient.dao.UserDAO;

public class RegistrationService {
	public boolean registrationValidate(RegistrationBean regBean) {
		UserDAO dao = new UserDAO();
		String uemail = regBean.getEmail();
		
		if (doesEmailExist(uemail)) {
			return false;
		}
		
		User user = new User();
		user.setEmail(uemail);
		user.setUserName(regBean.getUserName());
		user.setPassword(regBean.getPassword());
		user.setGender(regBean.getGender());
		
		return dao.insertUser(user);
		
	}
	
	public boolean doesEmailExist(String uemail) {
		UserDAO dao = new UserDAO();
		return dao.getUser(uemail)!=null;
	}
}
