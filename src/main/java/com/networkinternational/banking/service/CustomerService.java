package com.networkinternational.banking.service;

import com.networkinternational.banking.model.Customer;
import com.networkinternational.openapi.model.CustomerCreate;
import com.networkinternational.openapi.model.CustomerPut;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService{
    List<Customer> getCustomers();
    Customer getCustomerById(Long id);
    Customer addCustomer(CustomerCreate customer);
    void deleteCustomerById(Long id);
    Customer updateCustomer(CustomerPut customer);
}
