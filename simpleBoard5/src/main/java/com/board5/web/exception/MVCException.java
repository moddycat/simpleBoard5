package com.board5.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MVCException {
	
	@ExceptionHandler (Exception.class)
	public String errorHanlder() {
		
		return "error";
	}
	

}
