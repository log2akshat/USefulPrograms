package com.ms.user.service;

import com.ms.user.request.UserRegisterRequest;
import com.ms.user.response.UserRegisterResponse;

public interface UserService {

	public String registerUser(UserRegisterRequest request);

	public UserRegisterResponse getUser(String userId);

}
