package com.sapient.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sapient.services.AddAnswerService;

@WebServlet("/addAnswer")
public class AddAnswerController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		if (new AddAnswerService().uploadAnswer(req, session)) {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		} else {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Unablt to post answer at the moment');");
			out.println("location='ques-asn-detail.jsp';");
			out.println("</script>");

			req.getRequestDispatcher("/add-ans.jsp").include(req, resp);
		}

	}
}
