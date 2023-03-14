package com.tdd.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void addCustomer(CustomerDto customerDto) {
        validatePassport(customerDto.getNation());
        String decryptPassportNum = decryptPassportNumber(customerDto.getEncPassportNum());
        Customer customer = new Customer(customerDto.getName(), customerDto.getNation(), decryptPassportNum);
        customerRepository.save(customer);
    }

    private void validatePassport(String nation) {
        // 통신을 통해 데이터를 유효성 검토
        if (nation.length() != 3) {
            throw new IllegalArgumentException("passport is not valid");
        }
    }

    public String decryptPassportNumber(String passportNum) {
        Assert.isTrue(passportNum.length() == 20, "Passport is not Encrypt");
        return "M1234567";
    }

    public Customer findCustomerByPassport(String encPassportNum) {
        Assert.notNull(encPassportNum, "passportNum is not null");
        String decryptPassportNum = decryptPassportNumber(encPassportNum);
        return customerRepository.findByPassportNum(decryptPassportNum)
                .orElseThrow(IllegalArgumentException::new);
    }
}

