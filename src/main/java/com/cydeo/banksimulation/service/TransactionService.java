package com.cydeo.banksimulation.service;

import com.cydeo.banksimulation.model.Account;
import com.cydeo.banksimulation.model.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TransactionService {
    Transaction makeTransfer(BigDecimal amount, Date creationDate, Account sender, Account receiver, String message);

    List<Transaction> findAll();

}
