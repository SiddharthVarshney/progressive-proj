package com.sapient.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sapient.beans.Question;
import com.sapient.dao.QuestionDao;
import com.sapient.services.HomeService;

@WebServlet("/home")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(); 
		session.setAttribute("userId", 1);
		session.setAttribute("questionCount", new QuestionDao().getQuestionCount());
		
		HomeService questions = new HomeService();
		ArrayList<Question> quesList = questions.getAllQuestions();
		
		session.setAttribute("questionCount", quesList.size());
		req.setAttribute("questions", quesList);
		
		req.getRequestDispatcher("./index.jsp").forward(req, resp);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		doGet(req, resp);
	};

}
