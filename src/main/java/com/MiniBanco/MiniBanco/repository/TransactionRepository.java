package com.MiniBanco.MiniBanco.repository;

import com.MiniBanco.MiniBanco.Transactions.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
