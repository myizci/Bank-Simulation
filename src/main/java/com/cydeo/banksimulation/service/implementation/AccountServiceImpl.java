package com.cydeo.banksimulation.service.implementation;

import com.cydeo.banksimulation.model.Account;
import com.cydeo.banksimulation.enums.AccountType;
import com.cydeo.banksimulation.repository.AccountRepository;
import com.cydeo.banksimulation.service.AccountService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class AccountServiceImpl implements AccountService {


    AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createNewAccount(BigDecimal balance, Date creationDate, AccountType accountType, Long userId) {
        Account account = Account.builder()
                .id(UUID.randomUUID())
                .userId(userId)
                .accountType(accountType)
                .balance(balance)
                .creationDate(creationDate)
                .build();
        return accountRepository.save(account);
    }

    @Override
    public List<Account> listAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public void deleteAccount(UUID account) {
       // Account account =
        accountRepository.deleteAccount();
    }

    @Override
    public Account retrieveById(UUID account) {
        return accountRepository.findById(account);
    }

}
