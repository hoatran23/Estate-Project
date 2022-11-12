package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.converter.TransactionConverter;
import com.laptrinhjavaweb.dto.AssignmentCustomerDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.dto.response.ResponseDTO;
import com.laptrinhjavaweb.entity.*;
import com.laptrinhjavaweb.enums.TransactionTypesEnum;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.repository.TransactionRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Integer.parseInt;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionConverter transactionConverter;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<CustomerDTO> getCustomers() {
        List<CustomerEntity> customerEntities = new ArrayList<>();
        if (SecurityUtils.getAuthorities().contains("ROLE_MANAGER")) {
            customerEntities = customerRepository.findAll();
        }
        else if (SecurityUtils.getAuthorities().contains("ROLE_STAFF")) {
            Long staffId = SecurityUtils.getPrincipal().getId();
            customerEntities = customerRepository.findCustomerByStaffId(staffId);
        }
        List<CustomerDTO> results = new ArrayList<>();
        for (CustomerEntity customer: customerEntities) {
            CustomerDTO customerDTO = customerConverter.convertEntityToDTO(customer);
            results.add(customerDTO);
        }
        return results;
    }

    @Override
    @Transactional
    public ResponseDTO save(CustomerDTO customerDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        CustomerEntity customerEntity = customerConverter.convertDTOToEntity(customerDTO);

        // Set Staff
        if (customerEntity.getId() != null) {
            customerEntity.setUsers(customerRepository.findById(customerEntity.getId()).get().getUsers());
        }

        // Save building
        CustomerEntity result = customerRepository.save(customerEntity);

        // Set status response
        if (customerDTO.getId() != null) {
            responseDTO.setMessage("update_success");
            responseDTO.setDetail(customerEntity.getId().toString());
        } else {
            responseDTO.setMessage("insert_success");
            responseDTO.setDetail("");
        }

        return responseDTO;
    }

    @Override
    @Transactional
    public void assignmentCustomer(AssignmentCustomerDTO assignmentCustomerDTO) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(assignmentCustomerDTO.getCustomerId());
        List<UserEntity> userEntities = userRepository.findAllById(assignmentCustomerDTO.getStaffIds());
        customerEntity.get().setUsers(userEntities);
        customerRepository.save(customerEntity.get());
    }

    @Override
    public CustomerDTO findById(Long id) {
        CustomerEntity customerEntity = customerRepository.findById(id).get();
        CustomerDTO customerDTO = customerConverter.convertEntityToDTO(customerEntity);
        return customerDTO;
    }

    @Override
    public void deleteCustomer(List<Long> ids) {
        customerRepository.deleteInBatch(customerRepository.findAllById(ids));
    }

    @Override
    public List<CustomerDTO> searchCustomer(CustomerDTO customerDTO) {
        List<CustomerDTO> results = new ArrayList<>();

        if (SecurityUtils.getAuthorities().contains("ROLE_STAFF")) {
            Long staffId = SecurityUtils.getPrincipal().getId();
            customerDTO.setStaffId(staffId);
        }

        CustomerSearchBuilder customerSearchBuilder = customerConverter.converToCustomerSearchBuilder(customerDTO);
        List<CustomerEntity> customerEntities = customerRepository.findCustomers(customerSearchBuilder);

        for (CustomerEntity customer: customerEntities) {
            CustomerDTO responseDTO = customerConverter.convertEntityToDTO(customer);
            results.add(responseDTO);
        }
        return results;
    }

    @Override
    public Map<String, String> getTransactionsType() {
        Map<String, String> result = new HashMap<>();
        for (TransactionTypesEnum item: TransactionTypesEnum.values()) {
            result.put(item.getCode(), item.getValue());
        }
        return result;
    }

    @Override
    public ResponseDTO saveTransaction(TransactionDTO transactionDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        TransactionEntity transactionEntity = transactionConverter.convertDTOToEntity(transactionDTO);

        Optional<CustomerEntity> customerEntity = customerRepository.findById(transactionDTO.getCustomerId());
        transactionEntity.setCustomer(customerEntity.get());

        Long staffId = SecurityUtils.getPrincipal().getId();
        Optional<UserEntity> userEntity = userRepository.findById(staffId);
        transactionEntity.setStaff(userEntity.get());

        // Save building
        TransactionEntity result = transactionRepository.save(transactionEntity);

        // Set status response
        responseDTO.setMessage("insert_transaction");
        responseDTO.setDetail(transactionDTO.getCustomerId().toString());
        return responseDTO;
    }

    @Override
    public List<TransactionDTO> getTransactionsByCustomer(Long customerId) {
        List<TransactionEntity> transactionEntities = customerRepository.getTransactionsByCustomer(customerId);
        List<TransactionDTO> transactionDTOS = new ArrayList<>();

        for (TransactionEntity transactionEntity: transactionEntities) {
            TransactionDTO transactionDTO = transactionConverter.convertEntityToDTO(transactionEntity);
            transactionDTOS.add(transactionDTO);
        }

        return transactionDTOS;
    }
}
