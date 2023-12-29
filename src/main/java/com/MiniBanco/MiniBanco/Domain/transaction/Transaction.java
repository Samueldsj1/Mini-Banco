package com.MiniBanco.MiniBanco.Transactions;

import com.MiniBanco.MiniBanco.Domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name="transactions")
@Table(name="transactions")
@Getter@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name="payer_id")
    private User payer;
    @ManyToOne
    @JoinColumn(name= "payee_id")
    private User payee;
    private LocalDateTime transactionTime;

    public Transaction() {

    }
}
