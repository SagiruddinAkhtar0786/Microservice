package com.pracatice.Controller;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pracatice.Service.QuestionServie;
import com.pracatice.entity.Question;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	private QuestionServie questionService;
	
	@GetMapping("allQuestion")
	public ResponseEntity<List<Question>> getAllQuestion() {
		//return "hi These are your question!!!!!!!";
		try {
			return questionService.getAllQuestion();
	       // return new ResponseEntity<>(questionService.getAllQuestion(), HttpStatus.OK);


		}catch(Exception e) {
			e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());

		}
	//	return (new ArrayList<>());
	}
	
	/*@GetMapping("/all-question")
	public String getAllQuestion() {
	  System.out.println("this is testing part");
	    return "abc";
	}*/
	

	
//	@GetMapping("/all-question")
//	public ResponseEntity<List<Question>> getAllQuestion() {
//		//return "hi These are your question!!!!!!!";
//		try {
//			return questionService.getAllQuestion();
//	       // return new ResponseEntity<>(questionService.getAllQuestion(), HttpStatus.OK);
//
//
//		}catch(Exception e) {
//			e.printStackTrace();
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());
//
//		}
//	//	return (new ArrayList<>());
//	}
	
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
		return questionService.getQuestionByCategory(category);
	}
	
	@PostMapping("addQuestion") // to create the resource we need postman
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	
	@DeleteMapping("delete/{delId}")
	public String deleteQuestion(@PathVariable("delId") Integer id) {
		System.out.println("deleted Id :"+id);
		return questionService.delete(id);
	}
	
	@PutMapping("update/{upId}")
	public String updateQuestion(@PathVariable("upId") Integer id,@RequestBody Question question){
		return questionService.updateQuestionById(id,question);
	}

}
