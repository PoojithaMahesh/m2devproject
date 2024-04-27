package com.jsp.projectm2.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.projectm2.dao.BookingDao;
import com.jsp.projectm2.dao.CustomerDao;
import com.jsp.projectm2.dao.MedicineDao;
import com.jsp.projectm2.dto.BookingDto;
import com.jsp.projectm2.entity.Bookings;
import com.jsp.projectm2.entity.Customer;
import com.jsp.projectm2.entity.Medicine;
import com.jsp.projectm2.enums.BookingStatus;
import com.jsp.projectm2.exception.CustomerIdNotFoundException;
import com.jsp.projectm2.exception.MedicineIdNotFoundException;
import com.jsp.projectm2.util.ResponseStructure;

@Service
public class BookingService {

	@Autowired
	private BookingDao dao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private MedicineDao medicineDao;

	public ResponseEntity<ResponseStructure<Bookings>> addBooking(int customerId, int[] medcineId,
			BookingDto bookingDto) {
		Customer dbCustomer=customerDao.findCustomer(customerId);
		if(dbCustomer!=null) {
//			that customer is present and you can add booking
			Bookings bookings=this.mapper.map(bookingDto, Bookings.class);
			bookings.setCustomer(dbCustomer);
			List<Medicine> list=new ArrayList<Medicine>();
			
			for(int medId:medcineId) {
				Medicine dbMedicine=medicineDao.findMedicine(medId);
				if(dbMedicine!=null) {
//					that medicine is  present
					list.add(dbMedicine);
//					update the stockquantity of medicine
					dbMedicine.setStockQuantity(dbMedicine.getStockQuantity()-bookingDto.getQuantity());
				}else {
//					medicine is not present
					throw new MedicineIdNotFoundException("Sorry failed to add Booking");
				}
			}
//			end of the foreach loop
			
//			set the ;list of medicines to your booking
			bookings.setMedicines(list);
//			Update customer also with respect to Bookings
			List<Bookings> bookings2=new ArrayList<Bookings>();
			bookings2.add(bookings);
			dbCustomer.setBookings(bookings2);
			customerDao.updateCustomer(customerId, dbCustomer);
//			decide the booking status
			bookings.setBookingStatus(BookingStatus.ACTIVE);
			
//			shall i save this boooking
			
			Bookings dbBookings=dao.saveBooking(bookings);
			ResponseStructure<Bookings> structure=new ResponseStructure<>();
			structure.setMessage("Booking saved successfully");
            structure.setHttpStatus(HttpStatus.CREATED.value());
            structure.setData(dbBookings);
            return new ResponseEntity<ResponseStructure<Bookings>>(structure,HttpStatus.CREATED);
			
		}else {
//			customer is not present
			throw new CustomerIdNotFoundException("Sorry failed to add Bookings");
		}
	}
	
}
