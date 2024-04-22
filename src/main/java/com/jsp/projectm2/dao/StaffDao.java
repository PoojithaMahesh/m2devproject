package com.jsp.projectm2.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.projectm2.entity.Staff;
import com.jsp.projectm2.repo.StaffRepo;

@Repository
public class StaffDao {

	@Autowired
	private StaffRepo repo;

	public Staff saveStaff(Staff staff) {
		return repo.save(staff);
	}

	public Staff updateStaff(int staffId, Staff staff) {
		Optional<Staff> optional=repo.findById(staffId);
		if(optional.isPresent()) {
			staff.setAdmin(optional.get().getAdmin());
			staff.setMedicalStore(optional.get().getMedicalStore());
			staff.setStaffId(staffId);
			return repo.save(staff);
		}
		return null;
	}

	public Staff findStaff(int staffId) {
		Optional<Staff> optional=repo.findById(staffId);
		if(optional.isPresent()) {
			
			return optional.get();
		}
		return null;
	}

	public Staff deleteStaff(int staffId) {
		Optional<Staff> optional=repo.findById(staffId);
		if(optional.isPresent()) {
			repo.deleteById(staffId);
			return optional.get();
		}
		return null;
	}
	
}
