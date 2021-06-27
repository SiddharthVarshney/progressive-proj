package com.sapient.mongo.contracts;

import java.util.List;

import com.sapient.mongo.beans.Question;

public interface IQuestionDao {

	public void insertOne(Question question);
	public List<Question> findAll();
	public long getQuestionCount();
}
