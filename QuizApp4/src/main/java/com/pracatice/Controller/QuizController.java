package com.pracatice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pracatice.Service.QuizService;
import com.pracatice.entity.Question;
import com.pracatice.entity.QuestionWrapper;

@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@PostMapping("create")	
	public ResponseEntity<String> creatQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
		//return new ResponseEntity<>("I am here ",HttpStatus.OK);
		return quizService.createQuiz(category,numQ,title);
	}
	
	@GetMapping("getQuiz/{idx}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable ("idx") Integer id){
		return quizService.getQuizQuestion(id);
	}
}
