package com.cydeo.banksimulation.service.implementation;

import com.cydeo.banksimulation.dto.AccountDTO;
import com.cydeo.banksimulation.dto.TransactionDTO;
import com.cydeo.banksimulation.mapper.TransactionMapper;
import com.cydeo.banksimulation.model.Account;
import com.cydeo.banksimulation.model.Transaction;
import com.cydeo.banksimulation.enums.AccountType;
import com.cydeo.banksimulation.exception.AccountOwnerException;
import com.cydeo.banksimulation.exception.BadRequestException;

import com.cydeo.banksimulation.exception.BalanceNotSufficientException;
import com.cydeo.banksimulation.exception.UnderConstructionException;
import com.cydeo.banksimulation.repository.AccountRepository;
import com.cydeo.banksimulation.repository.TransactionRepository;
import com.cydeo.banksimulation.service.AccountService;
import com.cydeo.banksimulation.service.TransactionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TransactionServiceImpl implements TransactionService {

    @Value("${under_construction}")
    private boolean underConstruction;
    private final AccountService accountService;
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public TransactionServiceImpl(AccountService accountService, TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.accountService = accountService;
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public TransactionDTO makeTransfer(BigDecimal amount,
                                       Date creationDate,
                                       AccountDTO sender,
                                       AccountDTO receiver,
                                       String message) {
        if (!underConstruction) {
            checkAccountOwner(sender, receiver);
            validateAccounts(sender, receiver);
            executeBalanceAndUpdateIfRequired(amount, sender, receiver);
            TransactionDTO transactionDTO = new TransactionDTO(sender,receiver, amount,message,creationDate);

            transactionRepository.save(transactionMapper.convertToEntity(transactionDTO));

            return transactionDTO;
        }else{
            throw new UnderConstructionException("Make transfer is not possible for now, please try again later");
        }

    }

    private void executeBalanceAndUpdateIfRequired(BigDecimal amount, AccountDTO sender, AccountDTO receiver) {
        if(checkSenderBalance(sender,amount)){
            sender.setBalance(sender.getBalance().subtract(amount));
            receiver.setBalance(receiver.getBalance().add(amount));


        }else{
            throw new BalanceNotSufficientException("Balance is not enough for this transaction");
        }

    }

    private boolean checkSenderBalance(AccountDTO sender, BigDecimal amount) {
        return sender.getBalance().subtract(amount).compareTo(BigDecimal.ZERO)>0;
    }

    private void validateAccounts(AccountDTO sender, AccountDTO receiver) {
        if(sender==null || receiver==null){
            throw new BadRequestException("Sender or receiver cannot be null");
        }

        if(sender.getId().equals(receiver.getId())){
            throw new BadRequestException("Sender account needs to be different from receiver account");
        }

        findAccountById(sender.getId());
        findAccountById(receiver.getId());
        //

    }

    private AccountDTO findAccountById(Long accountId) {
        return accountService.retrieveById(accountId);
    }

    private void checkAccountOwner(AccountDTO sender, AccountDTO receiver) {
        if((sender.getAccountType().equals(AccountType.SAVINGS) ||
                receiver.getAccountType().equals(AccountType.SAVINGS))
                && !sender.getUserId().equals(receiver.getUserId())){
            throw new AccountOwnerException("When one of the account type is SAVINGS, sender and receiver has to be same person ");
        }
    }

    @Override
    public List<TransactionDTO> findAll() {

         List<Transaction> transactionList = transactionRepository.findAll();
         return transactionList.stream().map(transactionMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<TransactionDTO> retrieveLastTransaction() {

        return transactionRepository.findLastTenTransactions().stream().map(transactionMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<TransactionDTO> findTransactionListById(Long id) {
        return transactionRepository.findTransactionListById(id).stream().map(transactionMapper::convertToDTO).collect(Collectors.toList());
    }
}
