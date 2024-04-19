package com.jsp.projectm2.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class AddressDto {
	private int addressId;
	private String streetName;
	private String city;
	private String state;
	private long pincode;
//	Hii
}
