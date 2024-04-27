package com.jsp.projectm2.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerPasswordNotFoundException extends RuntimeException {

	private String message;
	
}
