package com.arha.commentable.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arha.commentable.bo.CommentBo;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

	@GetMapping("/{feedId}")
	public void list(@PathVariable Long feedId) {
		
		

	}

	@PostMapping("/{feedId}")
	public void save(@PathVariable Long feedId, @RequestBody @Valid CommentBo coomment) {

	}

	@DeleteMapping("/{feedId}") // user/feedid//admin
	public void delete(@PathVariable Long feedId) {

	}

	@PostMapping("/report/{feedId}")
	public void report(@PathVariable Long feedId) {

	}
}
