package com.pracatice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Question> getAllQuestion() {
		//return "hi These are your question!!!!!!!";
		return questionService.getAllQuestion();
	}

}
