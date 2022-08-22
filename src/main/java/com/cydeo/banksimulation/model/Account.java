package com.cydeo.banksimulation.model;

import com.cydeo.banksimulation.enums.AccountStatus;
import com.cydeo.banksimulation.enums.AccountType;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Positive
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    @NotNull
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Column(columnDefinition = "DATE")
    private Date creationDate;
    @NotNull
    private Long userId;


}
