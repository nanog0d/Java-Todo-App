package com.nano.todoapp.pojo;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class MethodArgumentNotPassed extends MethodArgumentNotValidException {

	private static final long serialVersionUID = 1L;

	public MethodArgumentNotPassed(MethodParameter parameter, BindingResult bindingResult) {
		super(parameter, bindingResult);
	}

}
