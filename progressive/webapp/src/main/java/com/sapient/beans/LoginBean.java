package com.sapient.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginBean {
	String email;
	String password;
	String name;
	Integer id;
} 
