package com.cydeo.banksimulation.converter;

import com.cydeo.banksimulation.dto.AccountDTO;
import com.cydeo.banksimulation.service.AccountService;
import org.springframework.core.convert.converter.Converter;

public class AccountConverter implements Converter<String,AccountDTO> {

    private final AccountService accountService;

    public AccountConverter(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public AccountDTO convert(String source) {
       if(source==null || source.equals("")){
           return null;
       }
       return accountService.retrieveById(Long.parseLong(source));
    }
}
