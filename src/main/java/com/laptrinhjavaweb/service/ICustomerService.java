package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.dto.AssignmentCustomerDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.dto.request.BuildingRequestDTO;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponseDTO;
import com.laptrinhjavaweb.dto.response.ResponseDTO;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<CustomerDTO> getCustomers();
    ResponseDTO save(CustomerDTO customerDTO);
    void assignmentCustomer(AssignmentCustomerDTO assignmentCustomerDTO);
    CustomerDTO findById(Long id);
    void deleteCustomer(List<Long> ids);
    List<CustomerDTO> searchCustomer(CustomerDTO customerDTO);
    Map<String, String> getTransactionsType();
    ResponseDTO saveTransaction(TransactionDTO transactionDTO);
    List<TransactionDTO> getTransactionsByCustomer(Long customerId);
}
