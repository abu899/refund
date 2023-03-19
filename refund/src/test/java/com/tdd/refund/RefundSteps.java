package com.tdd.refund;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class RefundSteps {
    public static RefundRequestDto makeRefundRequest() {
        int price = 30000;
        ProductCategory productCategory = ProductCategory.GLASSES;
        String passportNumber = "CDNVIE12APXKALXNDU27";
        Long shopId = 1L;
        return new RefundRequestDto(shopId, price, productCategory, passportNumber);
    }

    public static ExtractableResponse<Response> makeRefundApiRequest(RefundRequestDto refundRequestDto) {
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
                .param("encPassportNum", encPassportNum)
                .when()
                .get("/refund")
                .then()
                .log().all().extract();
    }
}
