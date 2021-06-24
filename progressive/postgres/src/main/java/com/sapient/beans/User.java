package com.sapient.beans;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User {
	private int userId;
	private String userName;
	private String password;
	private String gender;
	private String userEmail;
	private int userRating;
	
	
}
