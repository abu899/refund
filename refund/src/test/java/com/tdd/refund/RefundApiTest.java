package com.tdd.refund;

import com.tdd.ApiTest;
import com.tdd.customer.Customer;
import com.tdd.customer.CustomerRepository;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

public class RefundApiTest extends ApiTest {

    @MockBean
    CustomerRepository customerRepository;

    @MockBean
    RefundRepository refundRepository;

    @Test
    void refund() {
        RefundRequestDto refundRequestDto = RefundSteps.makeRefundRequest();

        given(customerRepository.findByPassportNum(anyString()))
                .willReturn(Optional.of(new Customer()));

        ExtractableResponse<Response> response = makeRefundApiRequest(refundRequestDto);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private ExtractableResponse<Response> makeRefundApiRequest(RefundRequestDto refundRequestDto) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(refundRequestDto)
                .when()
                .post("/refund")
                .then()
                .log().all().extract();
    }
}
