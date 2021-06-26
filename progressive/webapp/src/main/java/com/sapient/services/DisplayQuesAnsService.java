package com.sapient.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sapient.beans.Answer;
import com.sapient.dao.QuestionDao;

public class DisplayQuesAnsService {
	public List<Answer> getAllAnswerToAQuestion(HttpServletRequest req) {
		return new QuestionDao().getAnsForQuestion((Integer) (req.getAttribute("quesId")));
	}
}
