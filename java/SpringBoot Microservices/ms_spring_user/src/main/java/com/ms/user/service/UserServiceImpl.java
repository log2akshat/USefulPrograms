package com.ms.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.user.entity.UserRegisterEntity;
import com.ms.user.repository.UserRepository;
import com.ms.user.request.UserRegisterRequest;
import com.ms.user.response.UserRegisterResponse;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public String registerUser(UserRegisterRequest request) {
		UserRegisterEntity entity =
				UserRegisterEntity.builder()
				.name(request.getName())
				.email(request.getEmail())
				.mobile(request.getMobile())
				.city(request.getCity())
				.build();
		repository.save(entity);
		return "User details added successfully..";
	}

	@Override
	public UserRegisterResponse getUser(String userId) {
		Optional<UserRegisterEntity> entity = repository.findById(Integer.parseInt(userId));
		UserRegisterResponse userResponse = null;
		if(entity.isPresent()) {
			UserRegisterEntity entityResponse = entity.get();
			userResponse = UserRegisterResponse.builder()
					.name(entityResponse.getName())
					.email(entityResponse.getEmail())
					.mobile(entityResponse.getMobile())
					.city(entityResponse.getCity())
					.build();
		}
		return userResponse;
	}

}
