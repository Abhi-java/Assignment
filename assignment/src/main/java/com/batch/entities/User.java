package com.batch.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="user")
public class User {
	
	    @Id
	    @Column(name="Code")
		private String Code;
	    
	    @Column(name="SupplierID")
		private long SupplierID;
	    
	    @Column(name="Name")
		private String Name;
	    
	    @Column(name="Batch")
		private String Batch;
	    
	    @Column(name="Stock")
		private long Stock;
	    
	    @Column(name="Deal")
		private long Deal;
	    
	    @Column(name="Free")
		private long Free;
	    
	    @Column(name="Mrp")
		private Double Mrp;
	    
	    @Column(name="Rate")
		private Double Rate;
	    
	    @Column(name="Exp")
		private String Exp;
	    
	    @Column(name="Company")
		private String Company;
	    
	    @Column(name="Supplier")
		private String Supplier;
		
		
		public User() {
			
		}


		public long getSupplierID() {
			return SupplierID;
		}


		public void setSupplierID(long supplierID) {
			SupplierID = supplierID;
		}


		public String getCode() {
			return Code;
		}


		public void setCode(String code) {
			Code = code;
		}


		public String getName() {
			return Name;
		}


		public void setName(String name) {
			Name = name;
		}


		public long getStock() {
			return Stock;
		}


		public void setStock(long stock) {
			Stock = stock;
		}


		public long getDeal() {
			return Deal;
		}


		public void setDeal(long deal) {
			Deal = deal;
		}


		public String getBatch() {
			return Batch;
		}


		public void setBatch(String batch) {
			Batch = batch;
		}


		public long getFree() {
			return Free;
		}


		public void setFree(long free) {
			Free = free;
		}


		public Double getMrp() {
			return Mrp;
		}


		public void setMrp(Double mrp) {
			Mrp = mrp;
		}


		public Double getRate() {
			return Rate;
		}


		public void setRate(Double rate) {
			Rate = rate;
		}


		public String getExp() {
			return Exp;
		}


		public void setExp(String exp) {
			Exp = exp;
		}


		public String getCompany() {
			return Company;
		}


		public void setCompany(String company) {
			Company = company;
		}


		public String getSupplier() {
			return Supplier;
		}


		public void setSupplier(String supplier) {
			Supplier = supplier;
		}


		@Override
		public String toString() {
			return "User [SupplierID=" + SupplierID + ", Code=" + Code + ", Name=" + Name + ", Stock=" + Stock
					+ ", Deal=" + Deal + ", Batch=" + Batch + ", Free=" + Free + ", Mrp=" + Mrp + ", Rate=" + Rate
					+ ", Exp=" + Exp + ", Company=" + Company + ", Supplier=" + Supplier + "]";
		}


		

		
		
}
