package com.cydeo.banksimulation.repository;

import com.cydeo.banksimulation.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {


}
