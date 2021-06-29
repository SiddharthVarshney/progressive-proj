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
		return questionDao.saveQuestion(question) ?  "redirect:/all-questions.do" :"error";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path="/question-details")
	public String getQuestion(Model model, String quesid){
		model.addAttribute("question", questionDao.getQuestionById(Integer.parseInt(quesid)));
		return "show-one-question";
	}
	


    @RequestMapping(method = RequestMethod.GET, path="/questionupdate")
    public String getUpdateQuestionForm(Model model,String id) {
        Question que =  questionDao.getQuestionById(Integer.parseInt(id));
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+que);
        model.addAttribute("question",que);
        return "update-question";


    }
    
    @RequestMapping(method = RequestMethod.POST, path="/question")
    public String updateQuestion(@ModelAttribute ("question") Question question) {
        System.out.println(question);
        questionDao.updateQuestion(question);
        return "redirect:/all-questions.do";

    }
    




	
	
}
