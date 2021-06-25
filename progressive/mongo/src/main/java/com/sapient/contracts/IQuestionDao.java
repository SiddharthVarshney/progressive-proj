package com.sapient.contracts;

import java.util.List;

import com.sapient.beans.Question;

public interface IQuestionDao {

	public void insertOne(Question question);
	public List<Question> findAll();
	public int getQuestionCount();
}
