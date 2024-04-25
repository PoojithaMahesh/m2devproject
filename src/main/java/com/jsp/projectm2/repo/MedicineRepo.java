package com.jsp.projectm2.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.projectm2.entity.Medicine;

public interface MedicineRepo extends JpaRepository<Medicine, Integer>{
    @Query("select m from Medicine m where m.medicineName=?1")
	Optional<Medicine> findByName(String medicineName);

}
