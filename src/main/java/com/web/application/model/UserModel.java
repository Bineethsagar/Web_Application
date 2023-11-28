package com.web.application.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "User_Details")
public class UserModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	
	private String user_name;
	private String email_id;
	private String password;
	private String confirm_password;
	private boolean delete_flag;
	private Timestamp create_date;
	
	
}
