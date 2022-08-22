package com.cydeo.banksimulation.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @NotNull
    @ManyToOne(fetch= FetchType.LAZY)
    private Account sender;
    @NotNull
    @ManyToOne(fetch= FetchType.LAZY)
    private Account receiver;
    @NotNull
    @Positive
    private BigDecimal amount;
    @NotEmpty
    @Size(min = 2, max = 250)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String message;
    @Column(columnDefinition = "DATE")
    private Date creationDate;


}
