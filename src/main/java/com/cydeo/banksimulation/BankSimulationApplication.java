package com.cydeo.banksimulation;

import com.cydeo.banksimulation.model.Account;
import com.cydeo.banksimulation.enums.AccountType;
import com.cydeo.banksimulation.service.AccountService;
import com.cydeo.banksimulation.service.TransactionService;
import com.cydeo.banksimulation.service.implementation.AccountServiceImpl;
import com.cydeo.banksimulation.service.implementation.TransactionServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class BankSimulationApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(BankSimulationApplication.class, args);

    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
