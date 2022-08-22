package com.cydeo.banksimulation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    @NotNull
    private AccountDTO sender;

    @NotNull
    private AccountDTO receiver;

    @NotNull
    @Positive(message = "you cannot use negative values")
    private BigDecimal amount;

    @NotEmpty
    private String message;

    private Date creationDate;
}
