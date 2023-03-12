package com.tdd.customer;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerRepository {
    private Long sequence = 0L;
    private final Map<Long, Customer> persistence = new HashMap<>();

    public void save(Customer customer) {
        customer.assignId(++sequence);
        persistence.put(customer.getId(), customer);
    }
}
