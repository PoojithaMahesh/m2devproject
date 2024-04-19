package com.jsp.projectm2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.projectm2.dao.AddressDao;
import com.jsp.projectm2.dao.AdminDao;
import com.jsp.projectm2.dao.MedicalStoreDao;
import com.jsp.projectm2.dto.AddressDto;
import com.jsp.projectm2.dto.AdminDto;
import com.jsp.projectm2.dto.MedicalStoreDto;
import com.jsp.projectm2.entity.Address;
import com.jsp.projectm2.entity.Admin;
import com.jsp.projectm2.entity.MedicalStore;
import com.jsp.projectm2.exception.AddressIdNotFoundException;
import com.jsp.projectm2.exception.AdminIdNotFoundException;
import com.jsp.projectm2.exception.MedicalStoreIdNotFoundException;
import com.jsp.projectm2.util.ResponseStructure;

@Service
public class MedicalStoreService {

	@Autowired
	private MedicalStoreDao dao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private MedicalStoreDto dto;
	@Autowired
	private AddressDto addressDto;
	
	@Autowired
	private AdminDto adminDto;

	public ResponseEntity<ResponseStructure<MedicalStoreDto>> saveMedicalStore(int adminId, int addressId,
			MedicalStore store) {
		Admin dbAdmin=adminDao.findAdmin(adminId);
		if(dbAdmin!=null) {
//			admin is present and he is a valid admin
//			then im going to check address
			Address dbAddress=addressDao.findAddress(addressId);
			if(dbAddress!=null) {
//				adress is present then you can add store
//				next 2-4 lines is added in 19-04-2024
				store.setAdmin(dbAdmin);
				store.setAddress(dbAddress);
				MedicalStore dbMedicalStore=dao.saveMedicalStore(store);
				dbAddress.setMedicalStore(dbMedicalStore);
				dto.setManagerName(dbMedicalStore.getManagerName());
				dto.setName(dbMedicalStore.getName());
				dto.setPhone(dbMedicalStore.getPhone());
				dto.setStoreId(dbMedicalStore.getStoreId());
				dto.setStoreId(dbMedicalStore.getStoreId());
				Address address=dbMedicalStore.getAddress();
				addressDto.setAddressId(address.getAddressId());
				addressDto.setCity(address.getCity());
				addressDto.setPincode(address.getPincode());
				addressDto.setState(address.getState());
				addressDto.setStreetName(address.getStreetName());
				
				dto.setAddressDto(addressDto);
				
				Admin admin=dbMedicalStore.getAdmin();
				
				adminDto.setAdminEmail(admin.getAdminEmail());
				adminDto.setAdminId(admin.getAdminId());
				adminDto.setAdminName(admin.getAdminName());
				
				dto.setAdminDto(adminDto);
				
				
				ResponseStructure<MedicalStoreDto> structure=new ResponseStructure<>();
				structure.setMessage("MedicalStore saved successfully");
				structure.setHttpStatus(HttpStatus.CREATED.value());
				structure.setData(dto);
				return new ResponseEntity<ResponseStructure<MedicalStoreDto>>(structure,HttpStatus.CREATED);
			}else {
//				admin is the valid admin but address not found
				throw new AddressIdNotFoundException("Sorry failed to open the medicalstore");
			}
			
		}else {
//			admin is not present and then he is not a valid admin
			throw new AdminIdNotFoundException("Sorry failed to open medicalStore");
		}
	}

	

	public ResponseEntity<ResponseStructure<MedicalStoreDto>> updateMedicalStore(int storeId, MedicalStore store) {
		MedicalStore dbMedicalStore=dao.updateMedicalStore(storeId,store);
		if(dbMedicalStore!=null) {
//			updated successfully
			
			dto.setManagerName(dbMedicalStore.getManagerName());
			dto.setName(dbMedicalStore.getName());
			dto.setPhone(dbMedicalStore.getPhone());
			dto.setStoreId(dbMedicalStore.getStoreId());
			
			Address address=dbMedicalStore.getAddress();
			addressDto.setAddressId(address.getAddressId());
			addressDto.setCity(address.getCity());
			addressDto.setPincode(address.getPincode());
			addressDto.setState(address.getState());
			addressDto.setStreetName(address.getStreetName());
			
			dto.setAddressDto(addressDto);
			
			Admin admin=dbMedicalStore.getAdmin();
			adminDto.setAdminEmail(admin.getAdminEmail());
			adminDto.setAdminId(admin.getAdminId());
			adminDto.setAdminName(admin.getAdminName());
			
			dto.setAdminDto(adminDto);
			
			
			ResponseStructure<MedicalStoreDto> structure=new ResponseStructure<>();
			structure.setMessage("MedicalStore updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<MedicalStoreDto>>(structure,HttpStatus.OK);
			
			
			
		}else {
			throw new MedicalStoreIdNotFoundException("Sorry failed to update the MedicalStore");
		}
	}



	public ResponseEntity<ResponseStructure<MedicalStoreDto>> findMedicalStore(int storeId) {
	MedicalStore dbMedicalStore=dao.findMedicalStore(storeId);
	if(dbMedicalStore!=null) {
//		updated successfully
		
		dto.setManagerName(dbMedicalStore.getManagerName());
		dto.setName(dbMedicalStore.getName());
		dto.setPhone(dbMedicalStore.getPhone());
		dto.setStoreId(dbMedicalStore.getStoreId());
		
		Address address=dbMedicalStore.getAddress();
		addressDto.setAddressId(address.getAddressId());
		addressDto.setCity(address.getCity());
		addressDto.setPincode(address.getPincode());
		addressDto.setState(address.getState());
		addressDto.setStreetName(address.getStreetName());
		
		dto.setAddressDto(addressDto);
		
		Admin admin=dbMedicalStore.getAdmin();
		adminDto.setAdminEmail(admin.getAdminEmail());
		adminDto.setAdminId(admin.getAdminId());
		adminDto.setAdminName(admin.getAdminName());
		
		dto.setAdminDto(adminDto);
		
		
		ResponseStructure<MedicalStoreDto> structure=new ResponseStructure<>();
		structure.setMessage("MedicalStore updated successfully");
		structure.setHttpStatus(HttpStatus.FOUND.value());
		structure.setData(dto);
		return new ResponseEntity<ResponseStructure<MedicalStoreDto>>(structure,HttpStatus.FOUND);
		
		
		
	}else {
		throw new MedicalStoreIdNotFoundException("Sorry failed to fetch the MedicalStore");
	}
	}



	public ResponseEntity<ResponseStructure<MedicalStoreDto>> deleteMedicalStore(int storeId) {
		MedicalStore dbMedicalStore=dao.deleteMedicalStore(storeId);
		if(dbMedicalStore!=null) {
//			updated successfully
			
			dto.setManagerName(dbMedicalStore.getManagerName());
			dto.setName(dbMedicalStore.getName());
			dto.setPhone(dbMedicalStore.getPhone());
			dto.setStoreId(dbMedicalStore.getStoreId());
			
			Address address=dbMedicalStore.getAddress();
			addressDto.setAddressId(address.getAddressId());
			addressDto.setCity(address.getCity());
			addressDto.setPincode(address.getPincode());
			addressDto.setState(address.getState());
			addressDto.setStreetName(address.getStreetName());
			
			dto.setAddressDto(addressDto);
			
			Admin admin=dbMedicalStore.getAdmin();
			adminDto.setAdminEmail(admin.getAdminEmail());
			adminDto.setAdminId(admin.getAdminId());
			adminDto.setAdminName(admin.getAdminName());
			
			dto.setAdminDto(adminDto);
			
			
			ResponseStructure<MedicalStoreDto> structure=new ResponseStructure<>();
			structure.setMessage("MedicalStore updated successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<MedicalStoreDto>>(structure,HttpStatus.FOUND);
			
			
			
		}else {
			throw new MedicalStoreIdNotFoundException("Sorry failed to delete the MedicalStore");
		}
	}
	
}
