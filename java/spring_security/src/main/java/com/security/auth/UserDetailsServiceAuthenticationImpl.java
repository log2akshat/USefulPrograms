package com.security.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.entity.UserRegisterEntity;
import com.security.repository.UserRegisterRepository;

@Service
public class UserDetailsServiceAuthenticationImpl implements UserDetailsService {

	@Autowired
    UserRegisterRepository repository;

    @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserRegisterEntity> userRegisterDetails = repository.findByEmail(email);
		UserRegisterEntity userData = userRegisterDetails
				.orElseThrow(() -> new UsernameNotFoundException("Invalid Username"));
		return userData;
	}

}
