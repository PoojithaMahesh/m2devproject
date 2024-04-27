package com.jsp.projectm2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.projectm2.entity.Bookings;
import com.jsp.projectm2.repo.BookingRepo;

@Repository
public class BookingDao {

	@Autowired
	private BookingRepo repo;

	public Bookings saveBooking(Bookings bookings) {
		return repo.save(bookings);
	}
}
