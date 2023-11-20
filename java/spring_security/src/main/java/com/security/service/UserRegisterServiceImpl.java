package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.entity.UserRegisterEntity;
import com.security.repository.UserRegisterRepository;
import com.security.request.UserRegisterRequest;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

	@Autowired
	UserRegisterRepository repository;

	@Override
	public String createUserAccount(UserRegisterRequest request) {
		UserRegisterEntity userRegisterEntity = UserRegisterEntity.builder()
				.email(request.getEmail())
				.password(request.getPassword())
				.name(request.getName())
				.mobile(request.getMobile())
				.build();

		repository.save(userRegisterEntity);
		return "User registered successfully..";
	}

}
