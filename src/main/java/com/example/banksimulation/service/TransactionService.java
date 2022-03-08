package com.example.banksimulation.service;

import com.example.banksimulation.entity.Account;
import com.example.banksimulation.entity.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TransactionService {
    Transaction makeTransfer(BigDecimal amount, Date creationDate, Account sender, Account receiver, String message);

    List<Transaction> findAll();

}
