package com.security.auth;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTTokenHelper {

	@Value("${jwt.secret.key}")
	String secretKey;

	long JWT_TOKEN_VALIDITY_MILIS = 2*60000; // 2 Minutes

	// JWT Token Generation
	public String generateToken(String username) {
		String token = Jwts.builder()
				.setId(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY_MILIS))
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.compact();
		return token;
	}

	// Retrieve username from JWT Token
	public String getUsername(String token) {
		String username = Jwts.parser()
				.setSigningKey(secretKey)
				.parseClaimsJws(token)
				.getBody()
				.getId();
		return username;
	}

	// Check if token is expired
	private boolean isTokenExpired(String token) {
		final Date expirationTime = Jwts.parser()
				.setSigningKey(secretKey)
				.parseClaimsJwt(token)
				.getBody()
				.getExpiration();
		return expirationTime.before(new Date());
	}

	// Validate Token: username and expiration time
	public boolean validateToken(String username, String token) {
		final String user = getUsername(token);
		return (user.equals(username) && !isTokenExpired(token));
	}
}
