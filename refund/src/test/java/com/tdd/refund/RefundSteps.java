package com.tdd.refund;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class RefundSteps {
    public static RefundRequestDto makeRefundRequest() {
        int price = 30000;
        ProductCategory productCategory = ProductCategory.GLASSES;
        String passportNumber = "MDKEOQ2MCJDHAN128X0A";
        return new RefundRequestDto(price, productCategory, passportNumber);
    }

    static ExtractableResponse<Response> makeRefundApiRequest(RefundRequestDto refundRequestDto) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(refundRequestDto)
                .when()
                .post("/refund")
                .then()
                .log().all().extract();
    }

    public static ExtractableResponse<Response> findRefundApiRequest(String encPassportNum) {
        return RestAssured.given().log().all()
                .param("encPassportNum")
                .when()
                .get("/refund")
                .then()
                .log().all().extract();
    }
}
