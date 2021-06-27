package com.sapient.services;

import java.util.ArrayList;

import com.sapient.mongo.beans.Question;
import com.sapient.mongo.dao.QuestionDao;

public class HomeService {

	public ArrayList<Question> getAllQuestions(){
		return new QuestionDao().findAll();
	}
}
