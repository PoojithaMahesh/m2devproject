package com.jsp.projectm2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.projectm2.dao.AddressDao;
import com.jsp.projectm2.entity.Address;
import com.jsp.projectm2.exception.AddressIdNotFoundException;
import com.jsp.projectm2.util.ResponseStructure;

@Service
public class AddressService {
	
	
	@Autowired
	private AddressDao dao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		Address dbAddress=dao.saveAddress(address);
		ResponseStructure<Address> structure=new ResponseStructure<>();
		structure.setMessage("Address saved successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbAddress);
		return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(int addressId, Address address) {
		Address dbAddress=dao.updateAddress(addressId,address);
		if(dbAddress!=null) {
//			id is oresent
			ResponseStructure<Address> structure=new ResponseStructure<>();
			structure.setMessage("Address updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
		}else {
			throw new AddressIdNotFoundException("Sorry failed to update the data");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> findAddress(int addressId) {
		Address dbAddress=dao.findAddress(addressId);
		if(dbAddress!=null) {
//			id is oresent
			ResponseStructure<Address> structure=new ResponseStructure<>();
			structure.setMessage("Address fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
		}else {
			throw new AddressIdNotFoundException("Sorry failed to fetch the data");
		}
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int addressId) {
		Address dbAddress=dao.deleteAddress(addressId);
		if(dbAddress!=null) {
//			id is present
			ResponseStructure<Address> structure=new ResponseStructure<>();
			structure.setMessage("Address deleted successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND);
		}else {
			throw new AddressIdNotFoundException("Sorry failed to delete the data");
		}
	}

}
