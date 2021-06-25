package com.sapient.service;


import com.sapient.beans.LoginBean;
import com.sapient.beans.User;
import com.sapient.dao.UserDAO;

public class LoginService {
	public boolean registrationValidate(LoginBean loginBean) {
		UserDAO dao = new UserDAO();	
		User user = dao.getUser(loginBean.getEmail());
		return (loginBean.getPassword().equals(user.getPassword()));
		
	}

}
