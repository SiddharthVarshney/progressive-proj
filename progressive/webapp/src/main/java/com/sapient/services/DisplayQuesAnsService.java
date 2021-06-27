package com.sapient.services;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sapient.mongo.beans.Answer;
import com.sapient.mongo.beans.Question;
import com.sapient.mongo.dao.QuestionDao;



public class DisplayQuesAnsService {
	public List<Answer> getAllAnswerToAQuestion(HttpServletRequest req) {
		return new QuestionDao().getAnsForQuestion(Integer.parseInt(req.getParameter("quesId")));
	}

	public Question getQuestion(HttpServletRequest req) {
		return new QuestionDao().getQuestion(Integer.parseInt(req.getParameter("quesId")));
	}
}
