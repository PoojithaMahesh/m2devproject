package com.jsp.projectm2.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.jsp.projectm2.enums.BookingStatus;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Component
public class BookingDto {
	private int bookingId;
	private LocalDate orderDate;
	private  int quantity;
	private String paymentmode;
	private LocalDate expectedDate;
	private BookingStatus bookingStatus;
}
