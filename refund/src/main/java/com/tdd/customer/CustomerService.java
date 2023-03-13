package com.tdd.customer;

import com.tdd.refund.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RefundService refundService;

    public void addCustomer(CustomerDto customerDto) {
        refundService.validatePassport(customerDto.getNation());
        String decryptPassportNum = decryptPassportNumber(customerDto.getPassportNum());
        Customer customer = new Customer(customerDto.getName(), customerDto.getNation(), decryptPassportNum);
        customerRepository.save(customer);
    }

    public String decryptPassportNumber(String passportNum) {
        Assert.isTrue(passportNum.length() == 20, "Passport is not Encrypt");
        return "M1234567";
    }
}

