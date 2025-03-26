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
import com.pracatice.DAO.QuizDao;
import com.pracatice.entity.Question;
import com.pracatice.entity.QuestionWrapper;
import com.pracatice.entity.Quiz;

@Service
public class QuizService {
	@Autowired
	private QuizDao quizDao;

	@Autowired
	private QuestionDao questionDao;
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		// TODO Auto-generated method stub
		
		List<Question> questions = questionDao.findRandmQuesBycategory(category);
		questions = questions.stream().limit(numQ).collect(Collectors.toList());

		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(questions);
		quizDao.save(quiz);
		
		//quiz.setTitle(title);
		
		
		return new ResponseEntity<>("Success ",HttpStatus.CREATED);
	}
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
		// TODO Auto-generated method stub
		
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> quesFromDb = quiz.get().getQuestion();
		List<QuestionWrapper> questionForUser = new ArrayList<>();
		
		for(Question q : quesFromDb) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionForUser.add(qw);
		}
			
		
		return new ResponseEntity<>(questionForUser,HttpStatus.OK);
	}
	
	

}
