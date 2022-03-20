package com.nano.todoapp.util;

import com.nano.todoapp.pojo.CustomException;

public class ExceptionUtil {
	
	// making the instance static makes it singleton scoped 
	// but will have to initialize this in the methods if it is null
	// otherwise null pointer will be thrown.
	private static CustomException customException;
	
	public ExceptionUtil() {
		
	}
	
	// TODO: Create singleton instance of the custom exception that will be thrown with different messages.
	public static Object throwExceptionIftrueSingleton(boolean condition, String message) throws CustomException {
		// This is double checked locking for singleton class in which
		// we first null check for instance without locking and then,
		// we null check after the code block has been locked.
		// This way we make synchronized block more efficient in comparison
		// with making the method synchronized.
		if(customException == null) {
			synchronized(CustomException.class) {
				if(customException == null) customException = new CustomException();
			}
		}
		if(condition) {
//			System.out.println(customException.hashCode()); // the hash code will be same for all the custom exceptions thrown.
			System.out.println(customException.getMessage());
			customException.setMessage(message);
			throw customException;
		}
		
		return false;
	}
	
	public static Object throwExceptionIftrue(boolean condition, String message) throws CustomException {
		if(condition) {
			throw new CustomException(message);
		}
		
		return false;
	}

}
