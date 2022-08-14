package com.cydeo.banksimulation.controller;

import com.cydeo.banksimulation.model.Account;
import com.cydeo.banksimulation.model.Transaction;
import com.cydeo.banksimulation.service.AccountService;
import com.cydeo.banksimulation.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.UUID;

@Controller
public class TransactionController {

    private final AccountService accountService;
    private final TransactionService transactionService;

    public TransactionController(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    @GetMapping("/make-transfer")
    public String retrieveTransactionForm(Model model){
        model.addAttribute("accounts",accountService.listAllAccount());
        model.addAttribute("transaction", Transaction.builder().build());
        model.addAttribute("lastTransactionList",transactionService.retrieveLastTransaction());

        return "/transaction/make-transfer";
    }

    @PostMapping("/transfer")
    public String makeTransfer(@Valid @ModelAttribute("transaction")Transaction transaction, BindingResult bindingResult, Model model){


        if(bindingResult.hasErrors()){
            model.addAttribute("accounts",accountService.listAllAccount());
            return "/transaction/make-transfer";
        }

         Account receiver = accountService.retrieveById(transaction.getReceiver());
         Account sender = accountService.retrieveById(transaction.getSender());

         transactionService.makeTransfer(transaction.getAmount(),new Date(),sender,receiver,transaction.getMessage());

        return "redirect:/make-transfer";
    }

    @GetMapping("/transaction/{id}")
    public String transactionDetailById(@PathVariable("id") UUID id, Model model){

        model.addAttribute("transactionList", transactionService.findTransactionListById(id));

        return "transaction/transactions";

    }

}
