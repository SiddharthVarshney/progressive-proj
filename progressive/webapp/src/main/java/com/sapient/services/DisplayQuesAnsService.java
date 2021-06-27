package com.sapient.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sapient.beans.Answer;
import com.sapient.beans.Question;
import com.sapient.dao.QuestionDao;

public class DisplayQuesAnsService {
	public List<Answer> getAllAnswerToAQuestion(HttpServletRequest req) {
		return new QuestionDao().getAnsForQuestion(Integer.parseInt(req.getParameter("quesId")));
	}

	public Question getQuestion(HttpServletRequest req) {
		return new QuestionDao().getQuestion(Integer.parseInt(req.getParameter("quesId")));
	}
}
