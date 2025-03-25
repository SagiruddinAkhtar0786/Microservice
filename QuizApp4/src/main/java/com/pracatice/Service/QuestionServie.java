package com.pracatice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pracatice.DAO.QuestionDao;
import com.pracatice.entity.Question;

@Service
public class QuestionServie {
	
	/*public String getAllQuestion() {
		return "thiw sjhkjjjl!!!!!!";
	}*/
	
	@Autowired
	private QuestionDao questionDao;
	public List<Question> getAllQuestion(){
		//questionDao.getAllQuestion();
		return questionDao.findAll();
	}

}
