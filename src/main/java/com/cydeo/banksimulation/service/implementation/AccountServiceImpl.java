package com.cydeo.banksimulation.service.implementation;

import com.cydeo.banksimulation.dto.AccountDTO;
import com.cydeo.banksimulation.enums.AccountStatus;
import com.cydeo.banksimulation.mapper.AccountMapper;
import com.cydeo.banksimulation.model.Account;
import com.cydeo.banksimulation.enums.AccountType;
import com.cydeo.banksimulation.repository.AccountRepository;
import com.cydeo.banksimulation.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class AccountServiceImpl implements AccountService {


    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public Account createNewAccount(AccountDTO accountDTO) {

        accountDTO.setCreationDate(new Date());
        accountDTO.setAccountStatus(AccountStatus.ACTIVE);
        return accountRepository.save(accountMapper.covertToEntity(accountDTO));

    }

    @Override
    public List<AccountDTO> listAllAccount() {
        List<Account> accountList = accountRepository.findAll();

        //return accountList.stream().map(p-> accountMapper.convertToDTO(p)).collect(Collectors.toList());
        return accountList.stream().map(accountMapper::convertToDTO).collect(Collectors.toList());

    }

    @Override
    public List<AccountDTO> listAllActiveAccount() {
        List<Account> activeAccounts  = accountRepository.findAllByAccountStatus(AccountStatus.ACTIVE);
//        return activeAccounts.stream().map(p->accountMapper.convertToDTO(p)).collect(Collectors.toList());
        return activeAccounts.stream().map(accountMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long accountId) {
        Account account = accountRepository.getById(accountId);
        account.setAccountStatus(AccountStatus.DELETED);
        accountRepository.save(account);

    }

    @Override
    public AccountDTO retrieveById(Long account) {
        return accountMapper.convertToDTO(accountRepository.getById(account));
    }

}
