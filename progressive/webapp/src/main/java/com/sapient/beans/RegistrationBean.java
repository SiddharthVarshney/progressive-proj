package com.sapient.beans;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Super;

@Data
public class RegistrationBean extends User {
	public RegistrationBean(Integer userId, String userName, String email, String password, String gender,Double rating, Date createdAt) {
		super(userId, userName, email, password, gender, rating, createdAt);

	}

}
