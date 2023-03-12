package com.tdd.customer;

import com.tdd.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerApiTest extends ApiTest {

    @Test
    void customer() {
        CustomerDto customerRequest = CustomerSteps.getCustomerRequest();
        ExtractableResponse<Response> response = makeCustomerApiRequest(customerRequest);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private ExtractableResponse<Response> makeCustomerApiRequest(CustomerDto customerRequest) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(customerRequest)
                .when()
                .post("/customer")
                .then()
                .log().all().extract();
    }
}
