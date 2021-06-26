package com.sapient.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

	private int ansId;
	private int ansUserId;
	private String ansBody;
	private String answeredAt;
	
}
