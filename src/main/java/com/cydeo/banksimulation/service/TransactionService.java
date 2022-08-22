package com.cydeo.banksimulation.service;

import com.cydeo.banksimulation.dto.AccountDTO;
import com.cydeo.banksimulation.dto.TransactionDTO;
import com.cydeo.banksimulation.model.Account;
import com.cydeo.banksimulation.model.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TransactionService {
    TransactionDTO makeTransfer(BigDecimal amount, Date creationDate, AccountDTO sender, AccountDTO receiver, String message);

    List<TransactionDTO> findAll();

    List<TransactionDTO> retrieveLastTransaction();

    List<TransactionDTO> findTransactionListById(Long id);
}
