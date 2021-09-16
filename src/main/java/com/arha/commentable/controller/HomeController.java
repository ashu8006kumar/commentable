package com.arha.commentable.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {

	@GetMapping("")
	public String welcome() {
		return "Hi , Welcome to Spring boot RestController";
	}

	@GetMapping("/{name}")
	public String welcome(@PathVariable String name) {
		return "Hi " + name + ", Welcome to Spring boot RestController";
	}

}
