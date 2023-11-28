package com.web.application.dto;

import java.sql.Timestamp;

import com.web.application.model.UserModel;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRequestDto {

	private long user_id;
	private String user_name;
	private String email_id;
	private String password;
	private String confirm_password;
	private boolean delete_flag;
	private Timestamp create_date;
	
}
