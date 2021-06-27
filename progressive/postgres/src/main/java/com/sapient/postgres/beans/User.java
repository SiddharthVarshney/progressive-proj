package com.sapient.postgres.beans;

import java.util.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class User {
	private Integer userId = 0;
	private String userName="";
	private String email ="";
	private String password = "" ;
	private String gender = "";
	private Double rating = (double) 0;
	private Date createdAt = new Date();
	
	
}
