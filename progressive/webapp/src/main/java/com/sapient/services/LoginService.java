package com.sapient.services;


import com.sapient.beans.LoginBean;
import com.sapient.postgres.beans.User;
import com.sapient.postgres.dao.UserDAO;

public class LoginService {
	public LoginBean loginValidate(LoginBean loginBean) {
		UserDAO dao = new UserDAO();	
		User user = dao.getUser(loginBean.getEmail());
		if(user == null) return null;
		if(loginBean.getPassword().equals(user.getPassword())) {
			loginBean.setName(user.getUserName());
			loginBean.setId(user.getUserId());
			return loginBean;
		}
		return null;
		
	}

}