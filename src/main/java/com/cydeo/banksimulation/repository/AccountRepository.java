package com.cydeo.banksimulation.repository;

import com.cydeo.banksimulation.enums.AccountStatus;
import com.cydeo.banksimulation.model.Account;
import com.cydeo.banksimulation.exception.RecordNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    List<Account> findAllByAccountStatus(AccountStatus active);
}
