package com.pracatice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizServiceMicroserviceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizServiceMicroserviceProjectApplication.class, args);
	}

}
