package com.sapient.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sapient.beans.Answer;
import com.sapient.dao.QuestionDao;

public class AddAnswerService {
	private Answer createAnswerBean(HttpServletRequest req, HttpSession session) {
		Answer answer = new Answer();
		answer.setAnsUserId((Integer) session.getAttribute("userId"));
		answer.setAnsBody(req.getParameter("ansBody"));

		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		answer.setAnsweredAt(strDate);

		return answer;
	}

	public boolean uploadAnswer(HttpServletRequest req, HttpSession session) {
		int questionId = Integer.parseInt(req.getParameter("quesId"));
		Answer answer = createAnswerBean(req, session);
		QuestionDao questionDao = new QuestionDao();
		questionDao.addAnswerToQuestion(answer, questionId);
		System.out.println("answer: " + req.getParameter("ansBody"));
		return true;
	}

}
