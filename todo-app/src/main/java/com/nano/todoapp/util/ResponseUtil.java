package com.nano.todoapp.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil extends ResponseEntity<Object>{
	
	public ResponseUtil(Object response, HttpStatus status) {
		super(response, status);
	}

//	public ResponseEntity<Object> getResponseEntity(Object data, HttpStatus status){
//		Map<String, Object> response = new HashMap<String, Object>();
//		response.put("status", status);
//		if(data != null) response.put("data", data);
//		return new ResponseEntity<Object>(response, status);
//	}
}
