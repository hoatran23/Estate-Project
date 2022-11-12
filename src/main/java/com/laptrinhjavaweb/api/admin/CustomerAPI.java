package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.AssignmentCustomerDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.dto.response.ResponseDTO;
import com.laptrinhjavaweb.dto.response.StaffResponseDTO;
import com.laptrinhjavaweb.service.impl.CustomerService;
import com.laptrinhjavaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "customerAPIOfAdmin")
@RequestMapping("/api/customer")
public class CustomerAPI {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        ResponseDTO responseDTO = customerService.save(customerDTO);
        return responseDTO;
    }

    @GetMapping("/staffs")
    public ResponseDTO loadStaff(@RequestParam(value = "customerid") Long customerId) {
        ResponseDTO result = new ResponseDTO();
        List<StaffResponseDTO> listCustomerAssignedStaff = userService.getCustomerAssignedStaff(customerId);
        result.setData(listCustomerAssignedStaff);
        result.setMessage("success");
        return result;
    }

    @PostMapping("/staffs")
    public ResponseDTO assignCustomer(@RequestBody AssignmentCustomerDTO assignmentCustomerDTO) {
        ResponseDTO result = new ResponseDTO();
        customerService.assignmentCustomer(assignmentCustomerDTO);
        result.setMessage("insert_success");
        return result;
    }

    @DeleteMapping
    public void deleteCustomer(@RequestBody List<Long> ids) {
        customerService.deleteCustomer(ids);
    }

    @PostMapping("/search")
    public ResponseDTO searchCustomer(@RequestBody CustomerDTO customerDTO) {
        List<CustomerDTO> customerDTOS = customerService.searchCustomer(customerDTO);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(customerDTOS);
        if (customerDTOS != null) {
            responseDTO.setMessage("ok");
        }
        return responseDTO;
    }

    @PostMapping("/transaction")
    public ResponseDTO addTransaction(@RequestBody TransactionDTO transactionDTO) {
        ResponseDTO responseDTO = customerService.saveTransaction(transactionDTO);
        return responseDTO;
    }
}
