package com.web.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.application.dto.ResponseDto;
import com.web.application.dto.UserRequestDto;
import com.web.application.repository.UserRepository;
import com.web.application.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/register")
	public ResponseEntity<?> userRegistration(@RequestBody UserRequestDto request) {
		ResponseDto response = new ResponseDto();
		if(!request.getPassword().equals(request.getConfirm_password())) {
			response.setError_code(200);
			response.setError_message("password not matched");
		}else {
			return userService.userRegistration(request);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
}
	
	@DeleteMapping("/deleteUserByEmailId/{user_id}")
	public ResponseEntity<?> deleteUserByEmailId(@PathVariable long user_id) {
		ResponseDto response = new ResponseDto();
		userService.deleteUserByEmailId(user_id);
		response.setError_code(200);
		response.setError_message("deleted successfully");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}