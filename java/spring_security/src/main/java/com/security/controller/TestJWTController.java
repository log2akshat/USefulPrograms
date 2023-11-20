package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.util.JSONWebTokenHelper;

@RestController
@RequestMapping("/token")
public class TestJWTController {

	@Autowired
	JSONWebTokenHelper tokenUtil;

	@GetMapping("/generate")
	public String createJWTToken() {
		return tokenUtil.generateToken();
	}

	@GetMapping("/validate/{token}")
	public boolean getJWTTokenDetails(@PathVariable String token) {
		return tokenUtil.claimToken(token);
	}
}
