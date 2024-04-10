package com.org.springboot.Exception;

public class PassengerNotFoundException extends RuntimeException{

	private String message;

	public PassengerNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	
}
