package com.jsp.projectm2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.projectm2.entity.Admin;
import com.jsp.projectm2.service.AdminService;
import com.jsp.projectm2.util.ResponseStructure;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
    @PostMapping
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin){
		return service.saveAdmin(admin);
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @PutMapping
    public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestParam int adminId,@RequestBody Admin admin){
    	return service.updateAdmin(adminId,admin);
    }
	
    @GetMapping
    public ResponseEntity<ResponseStructure<Admin>> findAdmin(@RequestParam int adminId){
    	return service.findAdmin(adminId);
    }
    
    @DeleteMapping
    public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@RequestParam int adminId){
    	return service.deleteAdmin(adminId);
    }
    
    
    
    
    
    
    
}
