package com.jsp.projectm2.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.projectm2.entity.Address;
import com.jsp.projectm2.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepo repo;

	public Address saveAddress(Address address) {
		return repo.save(address);
	}

	public Address updateAddress(int addressId, Address address) {
		Optional<Address> optional=repo.findById(addressId);
		if(optional.isPresent()) {
			address.setAddressId(addressId);
			return repo.save(address);
		}
		return null;
	}

	public Address findAddress(int addressId) {
		Optional<Address> optional=repo.findById(addressId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Address deleteAddress(int addressId) {
		Optional<Address> optional=repo.findById(addressId);
		if(optional.isPresent()) {
//			id is present so i can deete the data
			Address address=optional.get();
			repo.delete(address);
			return address;
		}
		return null;
	}
	
}
