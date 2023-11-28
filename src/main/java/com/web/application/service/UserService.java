package com.web.application.service;

import org.springframework.http.ResponseEntity;

import com.web.application.dto.UserRequestDto;

public interface UserService {
	
	ResponseEntity<?> userRegistration(UserRequestDto request);
	ResponseEntity<?> deleteUserByEmailId(long user_id);
	ResponseEntity<?> getUserByUserId(long user_id);

}
