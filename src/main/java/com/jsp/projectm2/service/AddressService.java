package com.jsp.projectm2.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.projectm2.dao.AddressDao;
import com.jsp.projectm2.dto.AddressDto;
import com.jsp.projectm2.entity.Address;
import com.jsp.projectm2.exception.AddressIdNotFoundException;
import com.jsp.projectm2.util.ResponseStructure;

@Service
public class AddressService {
	
	
	@Autowired
	private AddressDao dao;
	@Autowired
	private AddressDto dto;
	@Autowired
	private ModelMapper mapper;

	public ResponseEntity<ResponseStructure<AddressDto>> saveAddress(Address address) {
		Address dbAddress=dao.saveAddress(address);
		AddressDto addressDto=this.mapper.map(dbAddress, AddressDto.class);
		ResponseStructure<AddressDto> structure=new ResponseStructure<>();
		structure.setMessage("Address saved successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(addressDto);
		return new ResponseEntity<ResponseStructure<AddressDto>>(structure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<AddressDto>> updateAddress(int addressId, Address address) {
		Address dbAddress=dao.updateAddress(addressId,address);
		if(dbAddress!=null) {
			AddressDto addressDto=this.mapper.map(dbAddress, AddressDto.class);
//			id is oresent
			ResponseStructure<AddressDto> structure=new ResponseStructure<>();
			structure.setMessage("Address updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(addressDto);
			return new ResponseEntity<ResponseStructure<AddressDto>>(structure,HttpStatus.OK);
		}else {
			throw new AddressIdNotFoundException("Sorry failed to update the data");
		}
	}

	public ResponseEntity<ResponseStructure<AddressDto>> findAddress(int addressId) {
		Address dbAddress=dao.findAddress(addressId);
		if(dbAddress!=null) {
//			id is oresent
			AddressDto addressDto=this.mapper.map(dbAddress, AddressDto.class);
			ResponseStructure<AddressDto> structure=new ResponseStructure<>();
			structure.setMessage("Address fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(addressDto);
			return new ResponseEntity<ResponseStructure<AddressDto>>(structure,HttpStatus.FOUND);
		}else {
			throw new AddressIdNotFoundException("Sorry failed to fetch the data");
		}
	}

	public ResponseEntity<ResponseStructure<AddressDto>> deleteAddress(int addressId) {
		Address dbAddress=dao.deleteAddress(addressId);
		if(dbAddress!=null) {
//			id is present
			AddressDto addressDto=this.mapper.map(dbAddress, AddressDto.class);
			ResponseStructure<AddressDto> structure=new ResponseStructure<>();
			structure.setMessage("Address deleted successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(addressDto);
			return new ResponseEntity<ResponseStructure<AddressDto>>(structure,HttpStatus.FOUND);
		}else {
			throw new AddressIdNotFoundException("Sorry failed to delete the data");
		}
	}

}
