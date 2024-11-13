package com.ashok.MicroServices_QuizApp.dao;

import com.ashok.MicroServices_QuizApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
   List<Question> findByCategory(String category);
    @Query(value = "select * from question q where q.category= :category Order By RANDOM() LIMIT :numQ ",nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
