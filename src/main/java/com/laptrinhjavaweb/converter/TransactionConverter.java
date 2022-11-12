package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.entity.TransactionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class TransactionConverter {

    @Autowired
    private ModelMapper modelMapper;

    public TransactionEntity convertDTOToEntity(TransactionDTO transactionDTO) {
        TransactionEntity transactionEntity = modelMapper.map(transactionDTO, TransactionEntity.class);
        return transactionEntity;
    }

    public TransactionDTO convertEntityToDTO(TransactionEntity transactionEntity) {
        TransactionDTO transactionDTO = modelMapper.map(transactionEntity, TransactionDTO.class);
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        transactionDTO.setDateFormat(simpleDateFormat.format(transactionEntity.getCreatedDate()));
        return transactionDTO;
    }
}
