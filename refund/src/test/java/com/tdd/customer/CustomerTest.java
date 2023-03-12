package com.tdd.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerTest {
    @Autowired
    private CustomerService customerService;

    @Test
    void createCustomer() {
        CustomerDto customerDto = CustomerSteps.getCustomerRequest();
        customerService.addCustomer(customerDto);
    }
}
