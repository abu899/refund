package com.tdd.customer;

import com.tdd.refund.RefundService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CustomerTest {
    @Autowired
    private CustomerService customerService;

    @MockBean
    RefundService refundService;

    @Test
    void createCustomer() {
        CustomerDto customerDto = CustomerSteps.getCustomerRequest();
        customerService.addCustomer(customerDto);
    }

    @Test
    void findCustomerByPassportNum() {
        CustomerDto customerDto = CustomerSteps.getCustomerRequest();
        customerService.addCustomer(customerDto);

        FindCustomerDto findCustomerDto = getFindCustomerDto();
        Customer customer = customerService.findCustomerByPassport(findCustomerDto.getEncPassportNum());
        assertThat(customer).isNotNull();
        assertThat(customer.getPassportNum()).isEqualTo("M1234567");
    }

    private FindCustomerDto getFindCustomerDto() {
        String passportNum = "M1282057281929103849";
        return new FindCustomerDto(passportNum);
    }

}
