package com.sapient.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

	private String quesId;
	private Integer quesUserId;
	
	private String title;
	private String body;
	
	private int upvotes;
	private List<User> upVotesUserId;
	private int downvotes;
	private List<User> downVotesUserId;
	
	private List<String> tags;
	private String createdAt;
	private boolean closed;
    
	private String bestAnsId;
	private List<Answer> answers;
}
