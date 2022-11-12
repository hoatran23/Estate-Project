package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.request.BuildingRequestDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.utils.MapUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CustomerConverter {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerEntity convertDTOToEntity(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = modelMapper.map(customerDTO, CustomerEntity.class);
        return customerEntity;
    }

    public CustomerDTO convertEntityToDTO(CustomerEntity customerEntity) {
        CustomerDTO customerDTO = modelMapper.map(customerEntity, CustomerDTO.class);
        return customerDTO;
    }

    public CustomerSearchBuilder converToCustomerSearchBuilder(CustomerDTO customerDTO) {
        CustomerSearchBuilder customerSearchBuilder = new CustomerSearchBuilder.Builder()
                .setEmail(customerDTO.getEmail())
                .setStaffId(customerDTO.getStaffId())
                .setFullName(customerDTO.getFullName())
                .setPhone(customerDTO.getPhone())
                .build();
        return customerSearchBuilder;
    }
}
