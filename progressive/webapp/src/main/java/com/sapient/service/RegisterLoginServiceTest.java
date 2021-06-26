package com.sapient.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.sapient.beans.LoginBean;
import com.sapient.beans.RegistrationBean;
import com.sapient.dao.UserDAO;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegisterLoginServiceTest {
	
	@Test
	public void test_1_RegistrationValidate() {
		UserDAO dao = new UserDAO();
		dao.dropUsersTable();
		RegistrationBean regBean = new RegistrationBean(0, "username",
				"email", "password", "gender",
				(double) 0, new Date());
		assertTrue(new RegistrationService().registrationValidate(regBean));
	}
	
	@Test
	public void test_2_RegistrationValidate() {
		UserDAO dao = new UserDAO();
		RegistrationBean regBean = new RegistrationBean(0, "username",
				"email", "password", "gender",
				(double) 0, new Date());
		assertFalse(new RegistrationService().registrationValidate(regBean));
	}
	
	@Test
	public void test_3_LoginValidate() {
		UserDAO dao = new UserDAO();
		LoginBean loginBean = new LoginBean();
		loginBean.setEmail("wrongemail");;
		assertNull(new LoginService().loginValidate(loginBean));
	}
	
	@Test
	public void test_4_LoginValidate() {
		UserDAO dao = new UserDAO();
		LoginBean loginBean = new LoginBean();
		loginBean.setEmail("email");
		loginBean.setPassword("wrongpassword");
		assertNull(new LoginService().loginValidate(loginBean));
	}
	
	@Test
	public void test_5_LoginValidate() {
		UserDAO dao = new UserDAO();
		LoginBean loginBean = new LoginBean();
		loginBean.setEmail("email");
		loginBean.setPassword("password");
		assertNotNull(new LoginService().loginValidate(loginBean));
	}
}
