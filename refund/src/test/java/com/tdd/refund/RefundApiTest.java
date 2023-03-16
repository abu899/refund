package com.tdd.refund;

import com.tdd.ApiTest;
import com.tdd.customer.CustomerSteps;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import shop.ShopSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class RefundApiTest extends ApiTest {

    @Test
    void refund() {
        ShopSteps.createShopApiRequest(ShopSteps.createShopRequest());
        CustomerSteps.makeCustomerApiRequest(CustomerSteps.getCustomerRequest());
        RefundRequestDto refundRequestDto = RefundSteps.makeRefundRequest();

        ExtractableResponse<Response> response = RefundSteps.makeRefundApiRequest(refundRequestDto);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void find() {
        ShopSteps.createShopApiRequest(ShopSteps.createShopRequest());
        CustomerSteps.makeCustomerApiRequest(CustomerSteps.getCustomerRequest());

        RefundRequestDto refundRequestDto = RefundSteps.makeRefundRequest();
        RefundSteps.makeRefundApiRequest(refundRequestDto);

        String encPassportNum = "CDNVIE12APXKALXNDU27";
        ExtractableResponse<Response> response = RefundSteps.findRefundApiRequest(encPassportNum);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getInt("price")).isEqualTo(refundRequestDto.getPrice());
    }

    @Test
    void cancel() {
        ShopSteps.createShopApiRequest(ShopSteps.createShopRequest());
        CustomerSteps.makeCustomerApiRequest(CustomerSteps.getCustomerRequest());

        RefundRequestDto refundRequestDto = RefundSteps.makeRefundRequest();
        RefundSteps.makeRefundApiRequest(refundRequestDto);

        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .when()
                .param("refundId", 1L)
                .post("/cancel")
                .then()
                .log().all().extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        long cancelRefundId = response.jsonPath().getLong("refundId");
        String refundStatus = response.jsonPath().getString("refundStatus");
        assertThat(cancelRefundId).isEqualTo(1L);
        assertThat(refundStatus).isEqualTo(RefundStatus.CANCEL.toString());
    }
}
