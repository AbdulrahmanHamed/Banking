package com.networkinternational.banking.service.impl;

import com.networkinternational.banking.exception.CustomerNotFoundException;
import com.networkinternational.banking.model.Customer;
import com.networkinternational.banking.repository.CustomerRepository;
import com.networkinternational.banking.service.CustomerService;
import com.networkinternational.openapi.model.CustomerCreate;
import com.networkinternational.openapi.model.CustomerPut;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    @Override
    public Customer addCustomer(CustomerCreate customer) {
        Customer newCustomer = new Customer();
        BeanUtils.copyProperties(customer, newCustomer);
        return customerRepository.save(newCustomer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
        }
    }

    @Override
    public Customer updateCustomer(CustomerPut customer) {
        Customer oldCustomer = customerRepository.findById(customer.getId()).orElseThrow(CustomerNotFoundException::new);
        BeanUtils.copyProperties(customer, oldCustomer);
        return customerRepository.save(oldCustomer);
    }
}
