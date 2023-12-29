package com.MiniBanco.MiniBanco.Domain.services;

import com.MiniBanco.MiniBanco.Domain.repository.TransactionRepository;
import com.MiniBanco.MiniBanco.Domain.transaction.TransactionDTO;
import com.MiniBanco.MiniBanco.Transactions.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.security.krb5.internal.ccache.MemoryCredentialsCache;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {

@Autowired
private UserService userService;

@Autowired
private RestTemplate restTemplate;
@Autowired
private TransactionRepository transactionRepository;

    public Object createTransaction(TransactionDTO transaction) throws Exception{
        var payer = this.userService.findUserById(transaction.payerId());
        var payee = this.userService.findUserById(transaction.payeeId());
        userService.validateUser(payer, transaction.amount());

        boolean isAuthorize = authorizeTransaction();
        if(!isAuthorize){
            throw new Exception("Não Autorizado!");
        }

        com.MiniBanco.MiniBanco.Transactions.Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.amount());
        newTransaction.setPayee(payee);
        newTransaction.setPayer(payer);
        newTransaction.setTransactionTime(LocalDateTime.now());


        payer.setBalance(payer.getBalance().subtract(transaction.amount());
        payee.setBalance(payee.getBalance().add(transaction.amount()));

        this.repository.save(newTransaction);
        this.userService.saveUser(payee);
        this.userService.saveUser(payer);

    }
    public  boolean authorizeTransaction(){
        var response = restTemplate.getForEntity("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", Map.class);
        if (response.getStatusCode() == HttpStatus.OK){
            String message = (String) response.getBody().get("message");
            return "Autorizado".equalsIgnoreCase(message);
        }else return false;
    }
}
