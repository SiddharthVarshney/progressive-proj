package com.sapient.dao;

import java.util.ArrayList;
import java.util.List;

import com.sapient.utils.MongoUtil;

import lombok.extern.slf4j.Slf4j;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import com.sapient.beans.Question;
import com.sapient.contracts.IQuestionDao;

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
	public List<Question> findAll() {
		List<Question> questionList = new ArrayList<Question>();
		MongoCursor<Question> iterator = questionCol.find().iterator();
    	while(iterator.hasNext()) {
    		Question next = iterator.next();
    		log.info("{}", next);
    		questionList.add(next);
    	}
    	return questionList;
	}


	@Override
	public long getQuestionCount() {
		return questionCol.countDocuments();
	}

}
