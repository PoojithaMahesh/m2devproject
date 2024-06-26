package com.jsp.projectm2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.projectm2.util.ResponseStructure;

@RestControllerAdvice
public class OnlinePharmacyExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> adminIdnotFoundException(AdminIdNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("ADMIN ID NOT FOUND");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> adressIdnotFoundException(AddressIdNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("ADDRESS ID NOT FOUND");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> storeIdnotFoundException(
			MedicalStoreIdNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("STORE ID NOT FOUND");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> staffIdnotFoundException(StaffIdNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("STAFF ID NOT FOUND");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> medicineIdnotFoundException(
			MedicineIdNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("MEDICINE ID NOT FOUND");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> medicineNameNotFoundException(
			MedicineNameNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("MEDICINE NAME NOT FOUND");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> customeIdNotFoundException(CustomerIdNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("CUSTOMER ID NOT FOUND");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> customeEmailNotFoundException(
			CustometEmailNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("CUSTOMER EMAIL NOT FOUND");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> customePasswordNotFoundException(
			CustomerPasswordNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setMessage("CUSTOMER Password NOT FOUND Invalid Customer");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

}
