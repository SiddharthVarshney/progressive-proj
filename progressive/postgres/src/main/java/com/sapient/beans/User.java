package com.sapient.beans;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	private String gender;
	private int rating;
	private LocalDate createdAt;
	
	
}
