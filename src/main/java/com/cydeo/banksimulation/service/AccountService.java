package com.cydeo.banksimulation.service;

import com.cydeo.banksimulation.dto.AccountDTO;
import com.cydeo.banksimulation.entity.Account;

import java.util.List;

public interface AccountService {
    Account createNewAccount(AccountDTO accountDTO);
    List<AccountDTO> listAllAccount();
    List<AccountDTO> listAllActiveAccount();

    void deleteAccount(Long account);

    AccountDTO retrieveById(Long account);
}
