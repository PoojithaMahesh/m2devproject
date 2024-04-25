package com.jsp.projectm2.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerIdNotFoundException extends RuntimeException {
private String message;

}
