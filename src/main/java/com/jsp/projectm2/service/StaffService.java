package com.jsp.projectm2.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.projectm2.dao.AdminDao;
import com.jsp.projectm2.dao.MedicalStoreDao;
import com.jsp.projectm2.dao.StaffDao;
import com.jsp.projectm2.dto.StaffDto;
import com.jsp.projectm2.entity.Admin;
import com.jsp.projectm2.entity.MedicalStore;
import com.jsp.projectm2.entity.Staff;
import com.jsp.projectm2.exception.AdminIdNotFoundException;
import com.jsp.projectm2.exception.MedicalStoreIdNotFoundException;
import com.jsp.projectm2.exception.StaffIdNotFoundException;
import com.jsp.projectm2.util.ResponseStructure;

@Service
public class StaffService {

	@Autowired
	private StaffDao dao;
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private MedicalStoreDao storeDao;
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private StaffDto dto;
	@Autowired
	private ModelMapper mapper;

	public ResponseEntity<ResponseStructure<StaffDto>> saveStaff(int adminId, int storeId, Staff staff) {
		Admin admin=adminDao.findAdmin(adminId);
		if(admin!=null) {
//			admin is present
			staff.setAdmin(admin);
			MedicalStore store=storeDao.findMedicalStore(storeId);
			if(store!=null) {
//				store is present
				staff.setMedicalStore(store);
				Staff dbStaff=staffDao.saveStaff(staff);
				StaffDto dto=this.mapper.map(dbStaff, StaffDto.class);
				ResponseStructure<StaffDto> structure=new ResponseStructure<>();
				structure.setMessage("Staff saved successfully");
				structure.setHttpStatus(HttpStatus.CREATED.value());
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<StaffDto>>(structure,HttpStatus.CREATED);
			}else {
				throw new MedicalStoreIdNotFoundException("Sorry failed to add staff");
			}
		}else {
			throw new AdminIdNotFoundException("Sorry failed to save Staff");
		}
	}

	public ResponseEntity<ResponseStructure<StaffDto>> updateStaff(int staffId, Staff staff) {
		Staff dbStaff=dao.updateStaff(staffId,staff);
		if(dbStaff!=null) {
//			id is present then updated successfully
			StaffDto dto=this.mapper.map(dbStaff, StaffDto.class);
			ResponseStructure<StaffDto> structure=new ResponseStructure<>();
			structure.setMessage("Staff data updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<StaffDto>>(structure,HttpStatus.OK);
			
		}else {
//			id is not present
			throw new StaffIdNotFoundException("Sorry failed to update the staff");
		}
	}

	public ResponseEntity<ResponseStructure<StaffDto>> findStaff(int staffId) {
		Staff dbStaff=dao.findStaff(staffId);
		if(dbStaff!=null) {
//			id is present then updated successfully
			StaffDto dto=this.mapper.map(dbStaff, StaffDto.class);
			ResponseStructure<StaffDto> structure=new ResponseStructure<>();
			structure.setMessage("Staff data fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<StaffDto>>(structure,HttpStatus.FOUND);
			
		}else {
//			id is not present
			throw new StaffIdNotFoundException("Sorry failed to fetch the staff");
		}
	}

	public ResponseEntity<ResponseStructure<StaffDto>> deleteStaff(int staffId) {
		Staff dbStaff=dao.deleteStaff(staffId);
		if(dbStaff!=null) {
//			id is present then updated successfully
			StaffDto dto=this.mapper.map(dbStaff, StaffDto.class);
			ResponseStructure<StaffDto> structure=new ResponseStructure<>();
			structure.setMessage("Staff data deleted successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<StaffDto>>(structure,HttpStatus.FOUND);
			
		}else {
//			id is not present
			throw new StaffIdNotFoundException("Sorry failed to delete the staff");
		}
	}
}
