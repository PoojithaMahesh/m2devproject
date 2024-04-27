package com.jsp.projectm2.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.projectm2.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
     @Query("select c from Customer c where c.customerEMail=?1")
	Optional<Customer> findbyEmail(String email);

}
