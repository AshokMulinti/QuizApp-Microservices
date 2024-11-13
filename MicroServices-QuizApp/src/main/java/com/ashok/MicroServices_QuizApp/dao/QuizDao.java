package com.ashok.MicroServices_QuizApp.dao;

import com.ashok.MicroServices_QuizApp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
