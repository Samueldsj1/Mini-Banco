package com.MiniBanco.MiniBanco.Domain.transaction;

import java.math.BigDecimal;

public record TransactionDTO (
        BigDecimal amount,
        Long payerId,
        Long payeeId
){
}
