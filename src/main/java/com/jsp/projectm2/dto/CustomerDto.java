package com.jsp.projectm2.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Component
public class CustomerDto {
	private int customerId;
	private String customerName;
	private String customerEMail;
	
	@OneToMany
	private List<AddressDto> addressDtos;
	
	@OneToMany
	private List<BookingDto> bookingDtos;
}
