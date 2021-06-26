package com.sapient.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sapient.beans.Answer;
import com.sapient.services.DisplayQuesAnsService;

@WebServlet("/questionDetails")
public class DisplayQuesAnsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("ansUserId", 123);
		DisplayQuesAnsService answers = new DisplayQuesAnsService();

		List<Answer> ansList = answers.getAllAnswerToAQuestion(req);

		req.setAttribute("answers", ansList);

		req.getRequestDispatcher("./question-details.jsp").forward(req, resp);
	}

}
