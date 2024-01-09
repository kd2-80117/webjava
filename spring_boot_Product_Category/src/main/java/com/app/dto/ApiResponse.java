package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApiResponse {
	
	private LocalDateTime timestamp;
	private String message;
	
	public ApiResponse(String msg) {
		this.message=msg;
		this.timestamp=LocalDateTime.now();
	}
}
