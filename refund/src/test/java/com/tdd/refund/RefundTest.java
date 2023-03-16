package com.tdd.refund;

import com.tdd.customer.Customer;
import com.tdd.customer.CustomerRepository;
import com.tdd.shop.Shop;
import com.tdd.shop.ShopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class RefundTest {

    @Autowired
    private RefundService refundService;

    @MockBean
    CustomerRepository customerRepository;

    @MockBean
    RefundRepository refundRepository;

    @MockBean
    ShopService shopService;

    @Test
    void refund() {
        RefundRequestDto refundRequestDto = RefundSteps.makeRefundRequest();

        given(customerRepository.findByPassportNum(anyString()))
                .willReturn(Optional.of(new Customer()));

        given(shopService.findShopById(anyLong()))
                .willReturn(Shop.builder().build());

        refundService.addRefund(refundRequestDto);
    }
}
