package com.jsp.projectm2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.projectm2.entity.Bookings;

public interface BookingRepo  extends JpaRepository<Bookings, Integer>{

}
