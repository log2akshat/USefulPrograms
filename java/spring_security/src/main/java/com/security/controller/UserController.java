package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.request.UserLoginRequest;
import com.security.request.UserRegisterRequest;
import com.security.service.UserRegisterService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	UserRegisterService service;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/hello")
	public String sayHello() {
		return "Welcome to security";
	}

	@PostMapping("/register")
	public ResponseEntity<String> createUserAccount(@RequestBody UserRegisterRequest request) {
		request.setPassword(passwordEncoder.encode(request.getPassword()));
		return ResponseEntity.ok(service.createUserAccount(request));
	}

	@PostMapping("/login")
	public String login(@RequestBody UserLoginRequest request) {
		return "Validation Success";
	}

}
