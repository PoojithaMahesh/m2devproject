package com.jsp.projectm2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.projectm2.dao.AdminDao;
import com.jsp.projectm2.entity.Admin;
import com.jsp.projectm2.exception.AdminIdNotFoundException;
import com.jsp.projectm2.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	private AdminDao dao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		Admin dbAdmin=dao.saveAdmin(admin);
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		structure.setMessage("Admin data saved successfully");
		structure.setHttpStatus(HttpStatus.CREATED.value());
		structure.setData(dbAdmin);
		return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(int adminId, Admin admin) {
		Admin dbAdmin=dao.updateAdmin(adminId,admin);
		if(dbAdmin!=null) {
//			that admin is there and data updated successfully
			ResponseStructure<Admin> structure=new ResponseStructure<>();
			structure.setMessage("Data Updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dbAdmin);
			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
		}else {
//			that id is not present and data not updated
//			raise the exception
//			how to raise the exception
			throw new AdminIdNotFoundException("Sorry failed to update the data");
		}
	}
	public ResponseEntity<ResponseStructure<Admin>> findAdmin(int adminId) {
		Admin dbAdmin=dao.findAdmin(adminId);
		if(dbAdmin!=null) {
//			that admin is there and data updated successfully
			ResponseStructure<Admin> structure=new ResponseStructure<>();
			structure.setMessage("Data fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbAdmin);
			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.FOUND);
		}else {
//			that id is not present and data not fetched
//			raise the exception
//			how to raise the exception
			throw new AdminIdNotFoundException("Sorry failed to fetch the data");
		}
	}
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int adminId) {
		Admin dbAdmin=dao.deleteAdmin(adminId);
		if(dbAdmin!=null) {
//			that admin is there and data updated successfully
			ResponseStructure<Admin> structure=new ResponseStructure<>();
			structure.setMessage("Data Deleted successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dbAdmin);
			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.FOUND);
		}else {
//			that id is not present and data not fetched
//			raise the exception
//			how to raise the exception
			throw new AdminIdNotFoundException("Sorry failed to delete the data");
		}
	}
	
}
