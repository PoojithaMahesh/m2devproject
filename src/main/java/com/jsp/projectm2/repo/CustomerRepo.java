package com.jsp.projectm2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.projectm2.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
