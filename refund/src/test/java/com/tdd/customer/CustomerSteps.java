package com.tdd.customer;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public interface CustomerSteps {
    static CustomerDto getCustomerRequest() {
        String name = "Brett";
        String nation = "KOR";
        String encryptPassportNum = "CDNVIE12APXKALXNDU27";
        return new CustomerDto(name, nation, encryptPassportNum);
    }

    static ExtractableResponse<Response> makeCustomerApiRequest(CustomerDto customerRequest) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(customerRequest)
                .when()
                .post("/customer")
                .then()
                .log().all().extract();
    }
}
