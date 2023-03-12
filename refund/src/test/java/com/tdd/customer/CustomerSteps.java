package com.tdd.customer;

public interface CustomerSteps {
    static CustomerDto getCustomerRequest() {
        String name = "Brett";
        String nation = "KOR";
        String encryptPassportNum = "CDNVIE12APXKALXNDU27";
        return new CustomerDto(name, nation, encryptPassportNum);
    }
}
