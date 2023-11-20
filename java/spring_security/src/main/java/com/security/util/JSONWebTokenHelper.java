package com.security.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JSONWebTokenHelper {

	@Value("${jwt.secret.key}")
	String key;

	@Value("${user.id}")
	String userId;

	@Value("${token.issuer}")
	String tokenIssuer;

	// JWT Token Generation
	public String generateToken() {
		String token;
		token = Jwts.builder()
				.setId(userId)
				.setSubject("My first JWT creation")
				.setIssuer(tokenIssuer)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(30)))
				.signWith(SignatureAlgorithm.HS256, key.getBytes())
				.compact();
		return token;
	}

	// Claims: Reading details from generated token by passing secret
	public boolean claimToken(String token) {
		Claims claim = (Claims) Jwts.parser()
				.setSigningKey(key.getBytes())
				.parse(token)
				.getBody();

		System.out.println("Token Id: " + claim.getId());
		System.out.println("Token Subject: " + claim.getSubject());
		System.out.println("Token Issuer: " + claim.getIssuer());
		System.out.println("Token Issued at: " + claim.getIssuedAt());
		System.out.println("Token Expiry: " + claim.getExpiration());

		return claim.getExpiration().before(new Date(System.currentTimeMillis()));
	}

}
