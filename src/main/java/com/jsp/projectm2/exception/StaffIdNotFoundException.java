package com.jsp.projectm2.exception;

import lombok.Getter;

@Getter
public class StaffIdNotFoundException extends RuntimeException {

	private String message;

	public StaffIdNotFoundException(String message) {
		super();
		this.message = message;
	}
	
}
