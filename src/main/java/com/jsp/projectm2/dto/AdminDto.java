package com.jsp.projectm2.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class AdminDto {
	private int adminId;
	private String adminName;
	private String adminEmail;
}
