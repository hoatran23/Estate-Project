package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "fullname")
	private String fullName;
	
	@Column
	private String phone;
	
	@Column
	private String email;

	// @ManyToMany(mappedBy = "customers", fetch = FetchType.LAZY)
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "assignmentcustomer",
			joinColumns = @JoinColumn(name = "customerid", referencedColumnName = "id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "staffid", referencedColumnName = "id", nullable = false))
    private List<UserEntity> users = new ArrayList<>();
	
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
    private List<TransactionEntity> transactions = new ArrayList<>();

//	@OneToMany(mappedBy="staff")
//	private List<AssignmentCustomerEntity> staffs = new ArrayList<>();
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public List<TransactionEntity> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionEntity> transactions) {
		this.transactions = transactions;
	}
}
