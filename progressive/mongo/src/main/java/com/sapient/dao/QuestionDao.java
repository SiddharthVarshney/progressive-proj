package com.sapient.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.sapient.beans.Answer;
import com.sapient.beans.Question;
import com.sapient.contracts.IQuestionDao;
import com.sapient.utils.MongoUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuestionDao implements IQuestionDao {

	private MongoClient mongoClient; 
	private MongoDatabase progressiveProject;
	private MongoCollection<Question> questionCol;
	
	public QuestionDao() {
		mongoClient =  MongoUtil.mongoUtil(); 
		progressiveProject = mongoClient.getDatabase("progressiveProject");
		questionCol = progressiveProject.getCollection("questions", Question.class);
	}

	
	@Override
	public void insertOne(Question question) {
		questionCol.insertOne(question);
    	log.info("Inserted One ");
	}

	@Override
	public ArrayList<Question> findAll() {
		ArrayList<Question> questionList = new ArrayList<>();
		MongoCursor<Question> iterator = questionCol.find().iterator();
    	while(iterator.hasNext()) {
    		Question next = iterator.next();
    		log.info("{}", next);
    		questionList.add(next);
    	}
    	Collections.reverse(questionList);
    	return questionList;
	}


	@Override
	public long getQuestionCount() {
		return questionCol.countDocuments();
	}

	public int getAnswerCount(int quesId) {
		Question question = questionCol.find(Filters.eq("quesId", quesId)).first();
		return question.getAnswers().size();
	}

	public List<Answer> getAnsForQuestion(int quesId) {
		Question question = questionCol.find(Filters.eq("quesId", quesId)).first();
		return question.getAnswers();
	}

	public void addAnswerToQuestion(Answer answer, int quesId) {
		
		int answerId = getAnswerCount(quesId) + 1;
		answer.setAnsId(answerId);
		questionCol.updateOne(Filters.eq("quesId", quesId), Updates.addToSet("answers", answer));
	}


}
