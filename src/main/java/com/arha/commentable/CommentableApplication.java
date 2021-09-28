package com.arha.commentable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class CommentableApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentableApplication.class, args);
	}

}
