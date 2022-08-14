package com.cydeo.banksimulation.model;

import com.cydeo.banksimulation.enums.AccountStatus;
import com.cydeo.banksimulation.enums.AccountType;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class Account {


    private UUID id;
    @NotNull
    @Positive
    private BigDecimal balance;
    private AccountStatus accountStatus;
    @NotNull
    private AccountType accountType;
    private Date creationDate;
    @NotNull
    private Long userId;


}
