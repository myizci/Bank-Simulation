package com.example.banksimulation.service;

import com.example.banksimulation.entity.Account;
import com.example.banksimulation.enums.AccountType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface AccountService {
    Account createNewAccount(BigDecimal balance, Date creationDate, AccountType accountType, Long userId);
    List<Account> listAllAccount();
}
