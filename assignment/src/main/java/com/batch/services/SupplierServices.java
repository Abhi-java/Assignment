package com.batch.services;

import java.util.List;

import com.batch.entities.User;

public interface SupplierServices {

	public List<User> getSuppliers();
	
	public User getSupplier(long supplierID);
	


	


}
