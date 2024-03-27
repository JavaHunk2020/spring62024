package com.vistal.tech.exception;

//private , default , protected , public
public class SignupNotFoundException extends RuntimeException {
	
	public SignupNotFoundException(String message){
		super(message);
	}

}
