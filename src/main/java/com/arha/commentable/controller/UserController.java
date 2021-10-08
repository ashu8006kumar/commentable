package com.arha.commentable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arha.commentable.bo.UserBo;
import com.arha.commentable.service.UserService;

@RestController
@RequestMapping("/api/admin/users")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * List of all users
	 * 
	 * @return
	 */
	@GetMapping("")
	public List<UserBo> list() {
		try {
			return userService.list();
		} catch (Exception e) {
			throw new RuntimeException("Internal server error.");
		}
	}
}
