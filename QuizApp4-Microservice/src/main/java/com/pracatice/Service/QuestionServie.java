package com.pracatice.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	public ResponseEntity<List<Question>> getAllQuestion(){
		//questionDao.getAllQuestion();
		try {
			
			return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK); // status code handling
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST); // exception handling

	}
	
	
	public ResponseEntity<List<Question>> getQuestionByCategory(String categary) {
		// TODO Auto-generated method stub
		try {
			
			return new ResponseEntity<>(questionDao.findByCategory(categary),HttpStatus.OK);
		}catch(Exception e) {
		e.printStackTrace();
	}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

	}
	public ResponseEntity<String> addQuestion(Question ques) {
		//return questionDao.addQuestion(ques);
		try {
			questionDao.save(ques);
			return new ResponseEntity<>("successfull added",HttpStatus.CREATED);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>("something went wrong",HttpStatus.BAD_REQUEST);

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
