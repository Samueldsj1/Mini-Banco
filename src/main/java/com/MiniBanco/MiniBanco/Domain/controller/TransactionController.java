package com.MiniBanco.MiniBanco.Domain.controller;

import com.MiniBanco.MiniBanco.Domain.services.TransactionService;
import com.MiniBanco.MiniBanco.Domain.transaction.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @PostMapping
    public ResponseEntity<com.MiniBanco.MiniBanco.Transactions.Transaction> createTransaction(@RequestBody TransactionDTO transaction){
        var newTransaction = this.transactionService.createTransaction(transaction);
        return  new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }
}
