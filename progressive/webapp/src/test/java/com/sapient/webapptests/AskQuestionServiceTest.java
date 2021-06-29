package com.sapient.webapptests;

import static org.junit.Assert.*;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.mockito.Mockito.*;

import com.sapient.mongo.beans.Question;
import com.sapient.mongo.dao.QuestionDao;
import com.sapient.services.AskQuestionService;

public class AskQuestionServiceTest {

	@Test
	public void askQuestionPass() {
		QuestionDao mockDao = new QuestionDao();
		long count = mockDao.getQuestionCount();
		
		HttpServletRequest req = mock(HttpServletRequest.class);
		when(req.getParameter("title")).thenReturn("Dummy title");
		when(req.getParameter("body")).thenReturn("Dummy body");
		when(req.getParameter("quesTags")).thenReturn("Dummy, tags");
		
		HttpSession session = mock(HttpSession.class);
		when(session.getAttribute("questionCount")).thenReturn(count);
		when(session.getAttribute("userId")).thenReturn(100);

		assertTrue(new AskQuestionService().uploadQuestion(req, session));
	}
	
	
	@Test
	public void askQuestionFail() {
		
		HttpServletRequest req = mock(HttpServletRequest.class);
		when(req.getParameter("title")).thenReturn("Dummy title");
		when(req.getParameter("body")).thenReturn("Dummy body");
		when(req.getParameter("quesTags")).thenReturn("Dummy, tags");
		
		HttpSession session = mock(HttpSession.class);
		when(session.getAttribute("questionCount")).thenReturn(1000);
		when(session.getAttribute("userId")).thenReturn(100);

		assertFalse(new AskQuestionService().uploadQuestion(req, session));
		
	}

}
