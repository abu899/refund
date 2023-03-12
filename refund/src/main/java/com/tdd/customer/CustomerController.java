package com.tdd.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerDto customerDto) {
        customerService.addCustomer(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
