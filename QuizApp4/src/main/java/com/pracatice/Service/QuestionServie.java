package com.pracatice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pracatice.DAO.QuestionDao;
import com.pracatice.entity.Question;

@Service
public class QuestionServie {
	
	/*public String getAllQuestion() {
		return "thiw sjhkjjjl!!!
	}*/
	
	@Autowired
	private QuestionDao questionDao;
	
	public List<Question> getAllQuestion(){
		//questionDao.getAllQuestion();
		return questionDao.findAll();
	}
	
	
	public List<Question> getQuestionByCategory(String categary) {
		// TODO Auto-generated method stub
		return questionDao.findByCategory(categary);
	}
	
	public String addQuestion(Question ques) {
		//return questionDao.addQuestion(ques);
		questionDao.save(ques);
		return "successfull added";
	}


	public String delete(Integer id) {
		// TODO Auto-generated method stub
		questionDao.deleteById(id);;
		return "successfully Deleted";
	}


	public String updateQuestionById(int id,Question updateQuestion) {
		// TODO Auto-generated method stub
	Optional<Question> existingQues = questionDao.findById(id);
	//questionDao.exi
	if(existingQues.isPresent()) {
		questionDao.save(updateQuestion);
		return "successfully Updated";
	}
	else
		return "QUESTION  WITH ID	"+id+" not found";
	}

}
