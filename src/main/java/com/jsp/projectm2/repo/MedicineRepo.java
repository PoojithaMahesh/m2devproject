package com.jsp.projectm2.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.projectm2.entity.Medicine;

public interface MedicineRepo extends JpaRepository<Medicine, Integer>{

}
