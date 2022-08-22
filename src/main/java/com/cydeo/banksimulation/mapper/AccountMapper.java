package com.cydeo.banksimulation.mapper;

import com.cydeo.banksimulation.dto.AccountDTO;
import com.cydeo.banksimulation.model.Account;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    private final ModelMapper modelMapper;

    public AccountMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Account covertToEntity(AccountDTO accountDTO){
        return modelMapper.map(accountDTO, Account.class);
    }

    public AccountDTO convertToDTO(Account account){
        return modelMapper.map(account, AccountDTO.class);
    }

}