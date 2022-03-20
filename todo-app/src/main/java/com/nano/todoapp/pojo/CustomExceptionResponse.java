package com.nano.todoapp.pojo;

import org.springframework.http.HttpStatus;

public class CustomExceptionResponse {
	
	private String title;
	private String message;
	private HttpStatus status;
	
	public CustomExceptionResponse(String title, String message, HttpStatus status) {
		this.title = title;
		this.message = message;
		this.status = status;
	}
	public CustomExceptionResponse() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
