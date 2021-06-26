package com.sapient.dao;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runners.MethodSorters;

import com.sapient.beans.User;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDAOTest {
	@Test
	public void test_1_InsertUser() {
		UserDAO dao = new UserDAO();
		dao.dropUsersTable();
		User user = new User();
        user.setEmail("user@test.com");
        user.setUserName("testUser");
        boolean result = dao.insertUser(user);
        assertTrue(result);
	}
	
	@Test
	public void test_2_GetUserString() {
		UserDAO dao = new UserDAO();
		String email = "user@test.com";
		User returned = dao.getUser(email);
		assertEquals(email,returned.getEmail());
	}


}
