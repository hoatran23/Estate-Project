package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.TransactionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepositoryCustom {
    List<CustomerEntity> findCustomerByStaffId(Long staffId);
    List<CustomerEntity> findCustomers(CustomerSearchBuilder customerSearchBuilder);
    List<TransactionEntity> getTransactionsByCustomer(Long customerId);
}
