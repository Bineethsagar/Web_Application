package com.web.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	@GetMapping("/liveCheck")
	public String message() {
		System.out.println("Application is running");
		return "welcome to server side";
	}
}
