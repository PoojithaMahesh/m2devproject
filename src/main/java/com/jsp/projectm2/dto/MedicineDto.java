package com.jsp.projectm2.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MedicineDto {
	private int medicineId;
	private String medicineName;
	private double cost;
	private LocalDate expiryDate;
	private int stockQuantity;
	private String maufacturer;
	private String description;
}
