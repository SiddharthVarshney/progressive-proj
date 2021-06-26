package com.sapient.services;

import java.util.ArrayList;

import com.sapient.beans.Question;
import com.sapient.dao.QuestionDao;

public class HomeService {

	public ArrayList<Question> getAllQuestions(){
		return new QuestionDao().findAll();
	}
}
