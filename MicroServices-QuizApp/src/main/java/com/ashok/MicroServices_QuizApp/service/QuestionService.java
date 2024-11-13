package com.ashok.MicroServices_QuizApp.service;

import com.ashok.MicroServices_QuizApp.dao.QuestionDao;
import com.ashok.MicroServices_QuizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
      try {
          return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
      }catch(Exception e){
          e.printStackTrace();
      }
        return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
       try {
           return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
       }catch(Exception e){
           e.printStackTrace();
       }
        return new ResponseEntity<>(new ArrayList(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
       try {
           questionDao.save(question);
           return new ResponseEntity<>("Success", HttpStatus.CREATED);
       }catch(Exception e){
           e.printStackTrace();
       }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
       }

    public ResponseEntity<String> deleteQuestionById(int id) {
        try {
            questionDao.deleteById(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed to delete", HttpStatus.BAD_REQUEST);
        }

    public ResponseEntity<String> update(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed to Updated", HttpStatus.BAD_REQUEST);
    }
}