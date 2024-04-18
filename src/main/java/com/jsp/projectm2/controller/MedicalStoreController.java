package com.jsp.projectm2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.projectm2.dto.MedicalStoreDto;
import com.jsp.projectm2.entity.MedicalStore;
import com.jsp.projectm2.service.MedicalStoreService;
import com.jsp.projectm2.util.ResponseStructure;

@RestController
@RequestMapping("/medicalstore")
public class MedicalStoreController {

	@Autowired
	private MedicalStoreService service;
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<MedicalStoreDto>> saveMedicalStore(@RequestParam int adminId,
			@RequestParam int addressId ,@RequestBody MedicalStore store){
		return service.saveMedicalStore(adminId,addressId,store);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<MedicalStoreDto>> updateMedicalStore(@RequestParam int storeId,
			@RequestBody MedicalStore store){
		return service.updateMedicalStore(storeId,store);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<MedicalStoreDto>> findMedicalStore(@RequestParam int storeId){
		return service.findMedicalStore(storeId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<MedicalStoreDto>> deleteMedicalStore(@RequestParam int storeId){
		return service.deleteMedicalStore(storeId);
	}
}
