package com.networkinternational.banking.service;

import com.networkinternational.openapi.model.Balance;
import com.networkinternational.openapi.model.Deposit;
import com.networkinternational.openapi.model.Withdraw;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface BalanceService {
    Balance getCustomerBalance(Long id);

    void deposit(Long id, Deposit deposit);

    void withdraw(Long id, Withdraw withdraw);
}
