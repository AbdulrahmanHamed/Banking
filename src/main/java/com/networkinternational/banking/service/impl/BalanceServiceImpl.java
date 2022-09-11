package com.networkinternational.banking.service.impl;

import com.networkinternational.banking.exception.CustomerNotFoundException;
import com.networkinternational.banking.model.Customer;
import com.networkinternational.banking.repository.CustomerRepository;
import com.networkinternational.banking.service.BalanceService;
import com.networkinternational.openapi.model.Balance;
import com.networkinternational.openapi.model.Deposit;
import com.networkinternational.openapi.model.Withdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Balance getCustomerBalance(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
        Balance balance = new Balance();
        balance.setBalance(customer.getBalance());
        return balance;
    }

    @Override
    public void deposit(Long id, Deposit deposit) {
        Customer customer = customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
        customer.getBalance().add(deposit.getAmount());
    }

    @Override
    public void withdraw(Long id, Withdraw withdraw) {
        Customer customer = customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
        if(customer.getBalance().compareTo(withdraw.getAmount()) >= 0)
            customer.getBalance().subtract(withdraw.getAmount());
    }
}
