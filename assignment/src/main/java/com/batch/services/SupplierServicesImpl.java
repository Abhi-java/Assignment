package com.batch.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch.dao.SupplierDao;
import com.batch.entities.User;

@Service
public class SupplierServicesImpl implements SupplierServices {

	@Autowired
	private SupplierDao supplierDao;
	
	public SupplierServicesImpl(){
		
	}
	
	@Override
	public List<User> getSuppliers() {

		return supplierDao.findAll();
	
	}

	@Override
	public User getSupplier(long supplierID) {
		User user=null;
		for(User  user1: supplierDao.findAll()) {
		if(user1.getSupplierID()==supplierID && user1.getStock()>=1){
		 user=user1;
		}
	}
		return user;
		
	
	}

	
	
}
