package com.pracatice.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pracatice.entity.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer> { // table : Quiz  same name as class Quiz, type of Primary key : Integer

}
