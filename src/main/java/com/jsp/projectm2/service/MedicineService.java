package com.jsp.projectm2.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.projectm2.dao.MedicalStoreDao;
import com.jsp.projectm2.dao.MedicineDao;
import com.jsp.projectm2.dto.MedicineDto;
import com.jsp.projectm2.entity.MedicalStore;
import com.jsp.projectm2.entity.Medicine;
import com.jsp.projectm2.exception.MedicalStoreIdNotFoundException;
import com.jsp.projectm2.exception.MedicineIdNotFoundException;
import com.jsp.projectm2.exception.MedicineNameNotFoundException;
import com.jsp.projectm2.util.ResponseStructure;

@Service
public class MedicineService {

	@Autowired
	private MedicineDao dao;
	@Autowired
	private MedicalStoreDao  storeDao;
	@Autowired
	private ModelMapper mapper;

	public ResponseEntity<ResponseStructure<MedicineDto>> saveMedicine(int storeId, Medicine medicine) {
		MedicalStore store=storeDao.findMedicalStore(storeId);
		if(store!=null) {
//			that store is present then you can save the data
			medicine.setMedicalStore(store);
			Medicine dbMedicine=dao.saveMedicine(medicine);
			MedicineDto dto=this.mapper.map(dbMedicine, MedicineDto.class);
			ResponseStructure<MedicineDto> structure=new ResponseStructure<>();
			structure.setMessage("MedicineSaved successfully");
			structure.setHttpStatus(HttpStatus.CREATED.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<MedicineDto>>(structure,HttpStatus.CREATED);
		}else {
//			store id is not present
			throw new MedicalStoreIdNotFoundException("Sorry failed to save the medicine");
		}
	}

	public ResponseEntity<ResponseStructure<MedicineDto>> updateMedicine(int medicineId, Medicine medicine) {
		Medicine dbMedicine=dao.updateMedicine(medicineId,medicine);
		if(dbMedicine!=null) {
//			id is present and updated the data
			MedicineDto dto=this.mapper.map(dbMedicine, MedicineDto.class);
			ResponseStructure<MedicineDto> structure=new ResponseStructure<>();
			structure.setMessage("Medicine Updated successfully");
			structure.setHttpStatus(HttpStatus.OK.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<MedicineDto>>(structure,HttpStatus.OK);
		}else {
//			medicine id is not present
			throw new MedicineIdNotFoundException("Sorry failed to update the medicine");
		}
	}

	public ResponseEntity<ResponseStructure<MedicineDto>> findMedicine(int medicineId) {
		Medicine dbMedicine=dao.findMedicine(medicineId);
		if(dbMedicine!=null) {
//			id is present and updated the data
			MedicineDto dto=this.mapper.map(dbMedicine, MedicineDto.class);
			ResponseStructure<MedicineDto> structure=new ResponseStructure<>();
			structure.setMessage("Medicine fetched successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<MedicineDto>>(structure,HttpStatus.FOUND);
		}else {
//			medicine id is not present
			throw new MedicineIdNotFoundException("Sorry failed to fetch the medicine");
		}
	}

	public ResponseEntity<ResponseStructure<MedicineDto>> deleteMedicine(int medicineId) {
		Medicine dbMedicine=dao.deleteMedicine(medicineId);
		if(dbMedicine!=null) {
//			id is present and updated the data
			MedicineDto dto=this.mapper.map(dbMedicine, MedicineDto.class);
			ResponseStructure<MedicineDto> structure=new ResponseStructure<>();
			structure.setMessage("Medicine deleted successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<MedicineDto>>(structure,HttpStatus.FOUND);
		}else {
//			medicine id is not present
			throw new MedicineIdNotFoundException("Sorry failed to delete the medicine");
		}
	}

	public ResponseEntity<ResponseStructure<MedicineDto>> findMedicineByName(String medicineName) {
		Medicine dbMedicine=dao.findMedicineByName(medicineName);
		if(dbMedicine!=null) {
//			medicine is present with this name
			MedicineDto dto=this.mapper.map(dbMedicine, MedicineDto.class);
			ResponseStructure<MedicineDto> structure=new ResponseStructure<>();
			structure.setMessage("Medicine fetched by name successfully");
			structure.setHttpStatus(HttpStatus.FOUND.value());
			structure.setData(dto);
			return new ResponseEntity<ResponseStructure<MedicineDto>>(structure,HttpStatus.FOUND);
		}else {
//			medicine is not present
			throw new MedicineNameNotFoundException("Sorry failed to find the Medicine ByName");
		}
	}
}
