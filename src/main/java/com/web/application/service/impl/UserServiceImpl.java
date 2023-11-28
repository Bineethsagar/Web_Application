package com.web.application.service.impl;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.web.application.dto.ResponseDto;
import com.web.application.dto.UserRequestDto;
import com.web.application.model.UserModel;
import com.web.application.repository.UserRepository;
import com.web.application.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository user_repository;
	
	@Override
	public ResponseEntity<?> userRegistration(UserRequestDto request) {
		
		UserModel user_model = new UserModel();
		ResponseDto response = new ResponseDto();
		try {
		
		if(user_model!=null) {
				
			user_model.setUser_name(request.getUser_name());
			user_model.setEmail_id(request.getEmail_id());
			user_model.setPassword(request.getPassword());
			user_model.setConfirm_password(request.getConfirm_password());
			user_model.setDelete_flag(false);
			user_model.setCreate_date(new Timestamp(System.currentTimeMillis()));
			
			user_repository.save(user_model);
			response.setError_code(100);
			response.setError_message("success");
	}	
		}catch (Exception e) {
			response.setError_code(200);
			response.setError_message("failed");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

	@Override
	public ResponseEntity<?> deleteUserByEmailId(long user_id) {
		ResponseDto response = new ResponseDto();
	
		UserModel user_model = user_repository.getUserByUserId(user_id);
		
		if(user_model!=null) {
			if(user_model.isDelete_flag()) {
				response.setError_code(100);
				response.setError_message("deleted");
			}
		}else {
			user_model.setDelete_flag(true);
			user_repository.save(user_model);
			response.setError_code(200);
			response.setError_message("deleted");
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}


	@Override
	public ResponseEntity<?> getUserByUserId(long user_id) {
		ResponseDto response = new ResponseDto();
		UserModel user_model = user_repository.getUserByUserId(user_id);
		UserRequestDto request = new UserRequestDto();
		
		user_model.setUser_name(request.getUser_name());
		user_model.setEmail_id(request.getEmail_id());
		user_model.setPassword(request.getPassword());
		user_model.setConfirm_password(request.getConfirm_password());
		user_model.setDelete_flag(false);
		user_model.setCreate_date(new Timestamp(System.currentTimeMillis()));
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("An internal server error occurred. Please contact the administrator.");
	}

}
