package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	@PostMapping("/register")
	public String createUserAccount(@RequestBody UserRegisterRequest request) {
		return service.createUserAccount(request);
	}

	@GetMapping("/hello")
	public String sayHello() {
		return "Welcome to security";
	}

	@PostMapping("/login")
	public String login(@RequestBody UserLoginRequest request) {
		return "Validation Success";
	}

}
