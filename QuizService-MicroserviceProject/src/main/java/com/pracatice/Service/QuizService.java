package com.pracatice.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pracatice.DAO.QuizDao;
import com.pracatice.Feign.QuizInterface;
import com.pracatice.entity.QuestionWrapper;
import com.pracatice.entity.Quiz;
import com.pracatice.entity.Response;

@Service
public class QuizService {
	@Autowired
	private QuizDao quizDao;

	@Autowired
	QuizInterface quizInterface;
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Integer> question = quizInterface.getQuestionsForQuiz(category,numQ).getBody();
		
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		//quiz.setTitle(title);
		quiz.setQuestionIds(question);
		quizDao.save(quiz);
		
		
		return new ResponseEntity<>("Success ",HttpStatus.CREATED);
	}
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
		// TODO Auto-generated method stub
		Quiz quiz = quizDao.findById(id).get();
		List<Integer> questionIds = quiz.getQuestionIds();
//		Optional<Quiz> quiz = quizDao.findById(id);
//		List<Question> quesFromDb = quiz.get().getQuestion();
		ResponseEntity<List<QuestionWrapper> > questionForUser = quizInterface.getQuestionFromId(questionIds);
//		
//		for(Question q : quesFromDb) {
//			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
//			questionForUser.add(qw);
//		}
//			
		
		return questionForUser;
	}
	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
		
		ResponseEntity<Integer> score = quizInterface.getScore(responses);
		return score;
	}
	
	

}
