package com.arha.commentable.controller;

import java.util.HashSet;
import java.util.Set;

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
import com.arha.commentable.bo.TokenBo;
import com.arha.commentable.service.EmailService;
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

	@Autowired
	private EmailService emailService;
	/**
	 * 
	 * @param LoginBo
	 * This will take username and password 
	 * validate username and pass and genrate token
	 * @return 
	 * @return TokenBo
	 */
	@PostMapping("/login")
	public TokenBo login(@Valid @RequestBody LoginBo loginBo) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginBo.getUsername(), loginBo.getPassword()));
		
		UserDetails userDetail = userDetailsService.loadUserByUsername(loginBo.getUsername());
		return new TokenBo(jwtUtil.generateToken(userDetail));
	} 
	
	
	@GetMapping("/send-test-email")
	public void  sendEmail() {
		Set<String> to = new HashSet<>();
		to.add("ram_xyz@gmail.com");
		to.add("raj_xyz@gmail.com");
		emailService.sendEmail(to);
	} 
	

}
