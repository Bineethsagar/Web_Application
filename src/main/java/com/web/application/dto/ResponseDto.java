package com.web.application.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseDto {
	
	private int error_code;
	private String error_message;

}
