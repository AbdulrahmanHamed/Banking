package com.networkinternational.banking.controller;

import com.networkinternational.banking.service.BalanceService;
import com.networkinternational.openapi.api.CustomerApi;
import com.networkinternational.openapi.model.Balance;
import com.networkinternational.openapi.model.Deposit;
import com.networkinternational.openapi.model.Withdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
public class BalanceController implements CustomerApi {

    @Autowired
    private BalanceService balanceService;
    @Override
    public ResponseEntity<Void> deposit(BigDecimal customerId, Deposit deposit) {
        return CustomerApi.super.deposit(customerId, deposit);
    }

    @Override
    public ResponseEntity<Void> withdraw(BigDecimal customerId, Withdraw withdraw) {
        return CustomerApi.super.withdraw(customerId, withdraw);
    }

    @Override
    public ResponseEntity<Balance> getCustomerBalance(BigDecimal customerId) {
        return CustomerApi.super.getCustomerBalance(customerId);
    }
}
