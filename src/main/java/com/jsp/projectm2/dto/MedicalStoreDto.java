package com.jsp.projectm2.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Component
public class MedicalStoreDto {

	private int storeId;
	private String name;
	private String managerName;
	private long phone;
	@ManyToOne
	private AdminDto adminDto;
	@OneToOne
	private AddressDto addressDto;
}
