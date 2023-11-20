package com.security.auth;

/**
 * Custom Filter to handle every incoming request
 * by extending OncePerRequestFilter class.
 * 
 * This Filter also checks Token is available or
 * not as part of the Request.
 * 
 */

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTTokenFilter extends OncePerRequestFilter {

	Logger logger = LoggerFactory.getLogger(JWTTokenFilter.class);

	@Autowired
	JWTTokenHelper jwtTokenHelper;

	@Autowired
	UserDetailsServiceAuthenticationImpl userDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
		logger.info("Validatio of JWT Token by OncePerRequestFilter");

		String token = request.getHeader("Authorization");
		logger.info("JWT Token: " + token);

		String username = null;
		if(token != null) {
			username = jwtTokenHelper.getUsername(token);
			logger.info("Username retrieved from JWT Token: " + username);
		} else {
			logger.info("Token is missing, please provide the required token.");
		}
		
		if (username != null && 
				SecurityContextHolder.getContext().getAuthentication() == null) {
			// Fetch user details, to cross check username of Token with DB user details.
			UserDetails userDetails = userDetailService.loadUserByUsername(username);
			// If token is available validate token wrt user Id and expiration time Interval
			Boolean validToken = jwtTokenHelper.validateToken(userDetails.getUsername(), token);

			if(validToken) {
				UsernamePasswordAuthenticationToken authToken =
						new UsernamePasswordAuthenticationToken
						(userDetails, null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource()
						.buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
