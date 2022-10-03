package com.batch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.batch.entities.User;
import com.batch.services.SupplierServices;


@RestController
@EnableJpaRepositories
public class UserController {

	@Autowired
	private SupplierServices supplierServices;
	
	@GetMapping("/home")
	public String home() {
		return "welcome to the Application";
	}
	//get the product detail
	
	@GetMapping("/supplier")
	public List<User> getSuppliers() {
		
	return this.supplierServices.getSuppliers();
	}
	// get the supplier and stock details by supplier ID [1-88]
	
	@GetMapping("/supplier/{supplierID}")
	public User getSupplier(@PathVariable String supplierID) {
		return this.supplierServices.getSupplier(Long.parseLong(supplierID));
	}
	
	
}
	
