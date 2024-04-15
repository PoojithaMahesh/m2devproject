package com.jsp.projectm2.dto;

import java.util.List;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CustomerDto {
	private int customerId;
	private String customerName;
	private String customerEMail;
	
	@OneToMany
	private List<AddressDto> addressDtos;
	
	@OneToMany
	private List<BookingDto> bookingDtos;
}
