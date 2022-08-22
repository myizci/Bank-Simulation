package com.cydeo.banksimulation.mapper;

import com.cydeo.banksimulation.dto.TransactionDTO;
import com.cydeo.banksimulation.model.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    private final ModelMapper modelMapper;

    public TransactionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Transaction convertToEntity(TransactionDTO transactionDTO){

        return modelMapper.map(transactionDTO, Transaction.class);
    }

    public TransactionDTO convertToDTO (Transaction transaction){
        return modelMapper.map(transaction, TransactionDTO.class);
    }
}
