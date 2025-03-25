package com.pracatice.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pracatice.entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>{

}
