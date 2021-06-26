package com.sapient.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sapient.beans.Answer;
import com.sapient.dao.QuestionDao;

public class DisplayQuesAnsService {
	public List<Answer> getAllAnswerToAQuestion(HttpServletRequest req, HttpSession session) {
		return new QuestionDao().getAnsForQuestion((Integer) (session.getAttribute("quesId")));
	}
}
