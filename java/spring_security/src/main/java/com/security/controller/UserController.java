package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.auth.JWTTokenHelper;
import com.security.request.UserLoginRequest;
import com.security.request.UserRegisterRequest;
import com.security.response.UserLoginResponse;
import com.security.service.UserRegisterService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	UserRegisterService service;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JWTTokenHelper jwtTokenHelper;

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
	public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
		performAuthentication(request.getEmail(), request.getPassword());
		String token = jwtTokenHelper.generateToken(request.getEmail());
		return ResponseEntity.ok(new UserLoginResponse(token, request.getEmail()));
	}

	private void performAuthentication(String email, String password) {
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(email, password);
		try {
			authenticationManager.authenticate(auth);
		} catch (BadCredentialsException e) {
			throw new RuntimeException("Invalid credentials..");
		}
	}

}
