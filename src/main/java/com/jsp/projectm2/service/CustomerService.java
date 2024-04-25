package com.jsp.projectm2.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.projectm2.dao.AddressDao;
import com.jsp.projectm2.dao.CustomerDao;
import com.jsp.projectm2.dto.AddressDto;
import com.jsp.projectm2.dto.BookingDto;
import com.jsp.projectm2.dto.CustomerDto;
import com.jsp.projectm2.entity.Address;
import com.jsp.projectm2.entity.Bookings;
import com.jsp.projectm2.entity.Customer;
import com.jsp.projectm2.exception.AddressIdNotFoundException;
import com.jsp.projectm2.exception.CustomerIdNotFoundException;
import com.jsp.projectm2.util.ResponseStructure;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private ModelMapper mapper;

	public ResponseEntity<ResponseStructure<CustomerDto>> signUpCustomer(int addressId, Customer customer) {
		Address dbAddress=addressDao.findAddress(addressId);
		if(dbAddress!=null) {
//			that address is present then i can save cutomer
			List<Address> addresses=new ArrayList<Address>();
			addresses.add(dbAddress);
			customer.setAddresses(addresses);
			Customer dbCustomer=dao.saveCustomer(customer);
			CustomerDto dto=mapper.map(dbCustomer, CustomerDto.class);
			List<Address> list=dbCustomer.getAddresses();
			List<AddressDto> dtos=null;
			for(Address address:list) {
				AddressDto addressDto=this.mapper.map(address, AddressDto.class);
				dtos.add(addressDto);
			}
			List<Bookings> bookings=dbCustomer.getBookings();
			List<BookingDto> bookingDtos=null;
			for(Bookings b:bookings) {
				BookingDto bookingDto=this.mapper.map(b, BookingDto.class);
				bookingDtos.add(bookingDto);
			}
			dto.setAddressDtos(dtos);
			dto.setBookingDtos(bookingDtos);
			
			ResponseStructure<CustomerDto> structure=new ResponseStructure<CustomerDto>();
			structure.setMessage("Customer saved successfully");
			structure.setHttpStatus(HttpStatus.CREATED.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<CustomerDto>>(structure,HttpStatus.CREATED);
		}else {
			throw new AddressIdNotFoundException("Sorry Customer failed to signin because address is not present");
		}
		
	}

	public ResponseEntity<ResponseStructure<CustomerDto>> updateCustomer(int customerId, Customer customer) {
		Customer dbCustomer=dao.updateCustomer(customerId,customer);
		if(dbCustomer!=null) {
//			that id is present 
			CustomerDto dto=mapper.map(dbCustomer, CustomerDto.class);
			List<Address> list=dbCustomer.getAddresses();
			List<AddressDto> dtos=null;
			for(Address address:list) {
				AddressDto addressDto=this.mapper.map(address, AddressDto.class);
				dtos.add(addressDto);
			}
			List<Bookings> bookings=dbCustomer.getBookings();
			List<BookingDto> bookingDtos=null;
			for(Bookings b:bookings) {
				BookingDto bookingDto=this.mapper.map(b, BookingDto.class);
				bookingDtos.add(bookingDto);
			}
			dto.setAddressDtos(dtos);
			dto.setBookingDtos(bookingDtos);
			
			ResponseStructure<CustomerDto> structure=new ResponseStructure<CustomerDto>();
			structure.setMessage("Customer updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<CustomerDto>>(structure,HttpStatus.OK);
		}else {
//			customer Id is not present
			throw new CustomerIdNotFoundException("Sorry failed to updateCustomer");
		}
	}

	public ResponseEntity<ResponseStructure<CustomerDto>> findCustomer(int customerId) {
		Customer dbCustomer=dao.findCustomer(customerId);
		if(dbCustomer!=null) {
//			that id is present 
			CustomerDto dto=mapper.map(dbCustomer, CustomerDto.class);
			List<Address> list=dbCustomer.getAddresses();
			List<AddressDto> dtos=null;
			for(Address address:list) {
				AddressDto addressDto=this.mapper.map(address, AddressDto.class);
				dtos.add(addressDto);
			}
			List<Bookings> bookings=dbCustomer.getBookings();
			List<BookingDto> bookingDtos=null;
			for(Bookings b:bookings) {
				BookingDto bookingDto=this.mapper.map(b, BookingDto.class);
				bookingDtos.add(bookingDto);
			}
			dto.setAddressDtos(dtos);
			dto.setBookingDtos(bookingDtos);
			
			ResponseStructure<CustomerDto> structure=new ResponseStructure<CustomerDto>();
			structure.setMessage("Customer fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<CustomerDto>>(structure,HttpStatus.FOUND);
		}else {
//			customer Id is not present
			throw new CustomerIdNotFoundException("Sorry failed to fetch the data");
		}
	}

	public ResponseEntity<ResponseStructure<CustomerDto>> deleteCustomer(int customerId) {
		Customer dbCustomer=dao.deleteCustomer(customerId);
		if(dbCustomer!=null) {
//			that id is present 
			CustomerDto dto=mapper.map(dbCustomer, CustomerDto.class);
			List<Address> list=dbCustomer.getAddresses();
			List<AddressDto> dtos=null;
			for(Address address:list) {
				AddressDto addressDto=this.mapper.map(address, AddressDto.class);
				dtos.add(addressDto);
			}
			List<Bookings> bookings=dbCustomer.getBookings();
			List<BookingDto> bookingDtos=null;
			for(Bookings b:bookings) {
				BookingDto bookingDto=this.mapper.map(b, BookingDto.class);
				bookingDtos.add(bookingDto);
			}
			dto.setAddressDtos(dtos);
			dto.setBookingDtos(bookingDtos);
			
			ResponseStructure<CustomerDto> structure=new ResponseStructure<CustomerDto>();
			structure.setMessage("Customer deleted successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<CustomerDto>>(structure,HttpStatus.FOUND);
		}else {
//			customer Id is not present
			throw new CustomerIdNotFoundException("Sorry failed to delete the customer");
		}
	}
	
	
}
