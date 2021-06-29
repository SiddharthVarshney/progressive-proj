package com.springmvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.dao.QuestionDAO;
import com.springmvc.entity.Question;

@Controller
public class QuestionController {

	@Autowired
	private QuestionDAO questionDao;
	
	//displays all available questions
	@RequestMapping(method = RequestMethod.GET, path="/all-questions")
	public String getAllQuestions(Model model){
		model.addAttribute("title", "List of all Questions");
		model.addAttribute("questions", questionDao.getAllQuestions());
		return "show-questions";
	}
	
	//loads question form
	@RequestMapping(method = RequestMethod.GET, path="/add-question")
	public String addQuestion(Model model) {
		model.addAttribute("question", new Question());
		return "question-form";
	}
	
	
	//save question
	@RequestMapping(method = RequestMethod.POST, path="/save-question")
	public String saveQuestion(@ModelAttribute ("question") Question question) {
		return dao.saveQuestion(question) ? "show-questions" :"error";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path="/question-details/{quesid}")
	public String getQuestion(@PathVariable("quesid") int quesid, Model model){
		model.addAttribute("question", questionDao.getQuestionById(quesid));
		return "show-one-question";
	}
	
	
}
