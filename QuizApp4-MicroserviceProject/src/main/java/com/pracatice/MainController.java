package com.pracatice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Question")
public class MainController {
	
	@GetMapping("/home")
	public String HomeController() {
		System.out.println("Hoem....");
		return "Home";
	}

	

}
