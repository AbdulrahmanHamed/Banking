package com.networkinternational.banking.controller;

import com.networkinternational.banking.service.CustomerService;
import com.networkinternational.openapi.api.CustomerApi;
import com.networkinternational.openapi.model.Customer;
import com.networkinternational.openapi.model.CustomerCreate;
import com.networkinternational.openapi.model.CustomerPut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/banking/v1")
public class CustomerController implements CustomerApi {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    @Override
    public ResponseEntity<Customer> addCustomer(CustomerCreate customerCreate) {
        logger.info("Adding new customer!");
        Customer response = new Customer();
        BeanUtils.copyProperties(customerService.addCustomer(customerCreate),response);
        return ResponseEntity.created(null).body(response);
    }

    @Override
    public ResponseEntity<Void> updateCustomer(CustomerPut customerPut) {
        customerService.updateCustomer(customerPut);
        return ResponseEntity.ok(null);
    }
}
