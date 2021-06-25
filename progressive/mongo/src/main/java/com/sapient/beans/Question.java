package com.sapient.beans;

import java.util.List;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

	private int quesId;
	private int quesUserId;
	
	private String title;
	private String body;
	
	private int upvotes;
	private List<Integer> upVotesUserId;
	private int downvotes;
	private List<Integer> downVotesUserId;
	
	private List<String> tags;
	private String createdAt;
	private boolean closed;
    
	private String bestAnsId;
	private List<Answer> answers;
}
