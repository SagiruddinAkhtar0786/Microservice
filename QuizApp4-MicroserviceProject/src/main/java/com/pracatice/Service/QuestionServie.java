package com.pracatice.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pracatice.DAO.QuestionDao;
import com.pracatice.entity.Question;
//import com.pracatice.entity.Quiz;
import com.pracatice.entity.QuestionWrapper;
import com.pracatice.entity.Response;

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


	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestion) {
		// TODO Auto-generated method stub
		
		List<Integer> questions = questionDao.findRandmQuesBycategory(categoryName);
		questions = questions.stream().limit(numQuestion).collect(Collectors.toList());
		
		return new ResponseEntity<>(questions,HttpStatus.OK);
		//return null;
	}


	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionsIds) {
		// TODO Auto-generated method stub
		
		List<QuestionWrapper> wrappers = new ArrayList<>();
		List<Question> questions = new ArrayList<>();
		
		for(Integer id : questionsIds) {
			questions.add(questionDao.findById(id).get());
		}
		
		for(Question question : questions) {
			QuestionWrapper QuesWrap =new QuestionWrapper();
			
			QuesWrap.setId(question.getId());
			QuesWrap.setQuestionTitle(question.getQuestionTitle());
			QuesWrap.setOption1(question.getOption1());
			QuesWrap.setOption2(question.getOption2());
			QuesWrap.setOption3(question.getOption3());
			QuesWrap.setOption4(question.getOption4());
			wrappers.add(QuesWrap);
		}
		return new ResponseEntity<>(wrappers,HttpStatus.OK);
	}


	public ResponseEntity<Integer> getScore(List<Response> responses) {
		// TODO Auto-generated method stub
		
		
		int right = 0;
		
		for(Response res : responses) {
			//Optional<Question> questionOptional = questionDao.findById(res.getId().get());
			Question question = questionDao.findById(res.getId()).get();
		System.out.println(res.getResponse() +" :: "+question.getRightAnswer());
			
			if (res.getResponse().trim().equalsIgnoreCase(question.getRightAnswer().trim())) {
			    right++;
			}

			
		}
			
		return new ResponseEntity<>(right,HttpStatus.OK);
	
		//return null;
	}

}
