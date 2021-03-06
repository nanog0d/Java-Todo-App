package com.nano.todoapp.pojo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nano.todoapp.util.ResponseUtil;

@ControllerAdvice
// Don't extend this handler with ResponseEntityExceptionHandler otherwise we wont be able to catch the MethodArgumentNotValidException.
// This is because ResponseEntityExceptionHandler internally handles MethodArgumentNotValidException and thus we won't be able to catch it.
// If we use a custom exception class that extends MethodArgumentNotValidException, a lot of unnecessary information will be returned.
public class CustomExceptionHandler {
	public int i = 0;
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseUtil handleValidationException(MethodArgumentNotValidException exception){
		Map<String, String> errors = new HashMap<String, String>();
		exception.getBindingResult().getAllErrors().stream().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put("error_" + i++, message);
		});
		errors.put("status", "Bad Request - Missing Parameters");
		return new ResponseUtil(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseUtil handleException(CustomException exception){
//		Integer.toString(HttpStatus.BAD_REQUEST.value())
		CustomExceptionResponse exceptionResponse = new CustomExceptionResponse("Bad Request", exception.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseUtil(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	
}
