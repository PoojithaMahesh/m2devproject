package com.jsp.projectm2.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MedicalStoreIdNotFoundException extends RuntimeException {

	private String message;
	
	
}
