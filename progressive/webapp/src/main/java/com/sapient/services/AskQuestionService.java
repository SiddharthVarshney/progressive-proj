package com.sapient.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sapient.mongo.beans.Answer;
import com.sapient.mongo.beans.Question;
import com.sapient.mongo.dao.QuestionDao;
public class AskQuestionService {

	private Question createQuestionBean(HttpServletRequest req, HttpSession session) {
		
		Question question = new Question();
		question.setQuesId((Integer)session.getAttribute("questionCount") + 1);
		question.setQuesUserId((Integer)session.getAttribute("userId"));
		
		question.setTitle(req.getParameter("title"));
		question.setBody(req.getParameter("quesBody"));
		
		question.setTags(new ArrayList<>(
				Arrays.asList(req.getParameter("quesTags").split(",")) 
				));
		
		question.setUpvotes(0);
		question.setDownvotes(0);
		question.setUpVotesUserId(new ArrayList<>());
		question.setDownVotesUserId(new ArrayList<>());
		
		
		Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String strDate = dateFormat.format(date);  
		question.setCreatedAt(strDate);
		
		question.setClosed(false);
		question.setBestAnsId("");
		question.setAnswers(new ArrayList<>());
		
		return question;
		
	}
	
	public boolean uploadQuestion(HttpServletRequest req, HttpSession session) {
		
		Question question = createQuestionBean(req, session);
		QuestionDao questionDao = new QuestionDao();
		
		questionDao.insertOne(question);
		int count = (int)questionDao.getQuestionCount();
		
		if((int) session.getAttribute("questionCount") == count - 1) {
			session.setAttribute("questionCount", count);
			return true;
		}
		
		return false;
		
	}
}