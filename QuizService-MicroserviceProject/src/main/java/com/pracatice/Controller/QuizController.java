package com.pracatice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pracatice.Service.QuizService;
//import com.pracatice.entity.Question;
import com.pracatice.entity.QuestionWrapper;
import com.pracatice.entity.QuizDTO;
import com.pracatice.entity.Response;

@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@PostMapping("create")	
	public ResponseEntity<String> creatQuiz(@RequestBody QuizDTO quizDTO){ //Data transfer Object
		//return new ResponseEntity<>("I am here ",HttpStatus.OK);
		return quizService.createQuiz(quizDTO.getCategoryName(),quizDTO.getNumQuestion(),quizDTO.getTitle());
	}
	
	@GetMapping("getQuiz/{idx}") //http://localhost:8083/quiz/getQuiz/6
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable ("idx") Integer id){
		return quizService.getQuizQuestion(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
		return quizService.calculateResult(id,responses);
	}
}
