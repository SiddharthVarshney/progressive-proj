package com.springmvc.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.springmvc.util.MongoUtil;

import lombok.extern.slf4j.Slf4j;

import com.springmvc.entity.Question;

@Slf4j
@Component
public class QuestionDAO {

	private MongoClient mongoClient; 
	private MongoDatabase springMvcWorks;
	private MongoCollection<Question> questionCol;
	
	public QuestionDAO() {
		mongoClient =  MongoUtil.mongoUtil(); 
		springMvcWorks = mongoClient.getDatabase("springMvcWorks");
		questionCol = springMvcWorks.getCollection("springQuestions", Question.class);
	}
	
	public List<Question> getAllQuestions(){
		ArrayList<Question> questionList = new ArrayList<>();
		MongoCursor<Question> iterator = questionCol.find().iterator();
    	while(iterator.hasNext()) {
    		Question next = iterator.next();
    		questionList.add(next);
    	}
    	return questionList; 
	}
	
	public Question getQuestionById(int quesid) {
		return questionCol.find(Filters.eq("quesid", quesid)).first();
	}

	
	public long getQuestionCount() {
		return questionCol.countDocuments();
	}
	
	
	public boolean saveQuestion(Question question) {
		
		int count = (int) getQuestionCount();
		try {
			question.setQuesid(count+1);
			questionCol.insertOne(question);
			log.info("Inserted One ");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	    
	}
	
	public boolean updateQuestion(Question question) {
		
		System.out.println("------------------------------");
		System.out.println(question);
		System.out.println("-------------------------------");
        
		try {
			questionCol.updateOne(Filters.eq("quesid", question.getQuesid()),Updates.combine(Updates.set("question", question.getQuestion()),Updates.set("option1", question.getOption1()),Updates.set("option2", question.getOption2()),Updates.set("option3", question.getOption3()),Updates.set("option4", question.getOption4())));
//			questionCol.updateOne(null, null)
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
    }
	
	public boolean deleteQuestion(int questionId) {
        try {
			questionCol.deleteOne(Filters.eq("quesid", questionId));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
    }
	
}
