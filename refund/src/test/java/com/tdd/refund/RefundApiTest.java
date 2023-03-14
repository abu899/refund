package com.tdd.refund;

import com.tdd.ApiTest;
import com.tdd.customer.Customer;
import com.tdd.customer.CustomerService;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

public class RefundApiTest extends ApiTest {

    @MockBean
    CustomerService customerService;

    @MockBean
    RefundRepository refundRepository;

    @Test
    void refund() {
        RefundRequestDto refundRequestDto = RefundSteps.makeRefundRequest();

        given(customerService.findCustomerByPassport(anyString()))
                .willReturn(new Customer());

        ExtractableResponse<Response> response = RefundSteps.makeRefundApiRequest(refundRequestDto);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void find() {
        RefundRequestDto refundRequestDto = RefundSteps.makeRefundRequest();
        RefundSteps.makeRefundApiRequest(refundRequestDto);

        given(refundRepository.findByEncPassportNum(anyString()))
                .willReturn(Optional.of(
                        new Refund(
                                refundRequestDto.getPrice(),
                                refundRequestDto.getProductCategory(),
                                refundRequestDto.getPrice() * 0.1,
                                new Customer())
                ));

        String encPassportNum = "MDKEOQ2MCJDHAN128X0A";
        ExtractableResponse<Response> response = RefundSteps.findRefundApiRequest(encPassportNum);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getInt("price")).isEqualTo(refundRequestDto.getPrice());
    }

    @Test
    void cancel() {

    }
}
