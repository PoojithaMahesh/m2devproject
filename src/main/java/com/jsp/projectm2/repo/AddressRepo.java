package com.jsp.projectm2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.projectm2.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
