package com.sapient.controllers;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sapient.mongo.beans.Question;
import com.sapient.services.DisplayQuesAnsService;


@WebServlet("/questionDetails")
public class DisplayQuesAnsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("ansUserId", 123);
		DisplayQuesAnsService quesans = new DisplayQuesAnsService();

		Question question = quesans.getQuestion(req);

		req.setAttribute("question", question);

		req.getRequestDispatcher("./question-details.jsp").forward(req, resp);
	}
}