package com.sapient.beans;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class User {
	private Integer userId;
	private String userName;
	private String email;
	private String password;
	private String gender;
	private Double rating;
	private LocalDate createdAt;
	
	
}
