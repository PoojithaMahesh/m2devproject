package com.jsp.projectm2.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private String customerEMail;
	private String password;
	private long phoneNumber;
	@OneToMany(mappedBy = "customer")
	private List<Address> addresses;
	@OneToMany(mappedBy = "customer")
	private List<Bookings> bookings;
}
