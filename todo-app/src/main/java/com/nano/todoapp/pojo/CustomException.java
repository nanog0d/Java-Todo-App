package com.nano.todoapp.pojo;

public class CustomException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public CustomException() {}
	
	public CustomException(String message) {
		super(message);
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		if(this.message != null && !this.message.isEmpty()) return this.message;
		return super.getMessage();
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

}
