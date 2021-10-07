package com.arha.commentable.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arha.commentable.bo.LoginBo;
import com.arha.commentable.util.JwtUtil;

@RestController
@RequestMapping("/api/home")
public class HomeController {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	/**
	 * 
	 * @param LoginBo
	 * This will take username and password 
	 * validate username and pass and genrate token
	 * @return 
	 * @return TokenDto
	 */
	@PostMapping("/login")
	public String login(@Valid @RequestBody LoginBo loginBo) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginBo.getUsername(), loginBo.getPassword()));
		
		UserDetails userDetail = userDetailsService.loadUserByUsername(loginBo.getUsername());
		return jwtUtil.generateToken(userDetail);
	} 
	

}
