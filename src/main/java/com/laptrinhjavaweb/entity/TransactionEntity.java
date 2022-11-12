package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Optional;

@Entity
@Table(name = "transaction")
public class TransactionEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column
	private String note;
	
	@Column
	private String code;
	
	@ManyToOne
    @JoinColumn(name = "customerid")
	private CustomerEntity customer;

	@ManyToOne
	@JoinColumn(name = "staffid")
	private UserEntity staff;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public UserEntity getStaff() {
		return staff;
	}

	public void setStaff(UserEntity staff) {
		this.staff = staff;
	}
}
