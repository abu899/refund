package com.tdd.shop;

import com.tdd.ApiTest;
import com.tdd.customer.CustomerSteps;
import com.tdd.refund.RefundRequestDto;
import com.tdd.refund.RefundSteps;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import shop.ShopSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopApiTest extends ApiTest {

    @Test
    void shop() {
        CreateShopDto createShopDto = ShopSteps.createShopRequest();

        ExtractableResponse<Response> response = ShopSteps.createShopApiRequest(createShopDto);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void findRefunds() {
        int addRefundCount = 3;
        Long shopId = 1L;

        ShopSteps.createShopApiRequest(ShopSteps.createShopRequest());
        CustomerSteps.makeCustomerApiRequest(CustomerSteps.getCustomerRequest());

        RefundRequestDto refundRequestDto = RefundSteps.makeRefundRequest();
        int addRefundsCount = 3;
        for (int i = 0; i < addRefundsCount; i++) {
            RefundSteps.makeRefundApiRequest(refundRequestDto);
        }

        ExtractableResponse<Response> response = ShopSteps.makeShopFindApiRequest(shopId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getInt("totalPrice")).isEqualTo(refundRequestDto.getPrice() * addRefundCount);
        assertThat(response.jsonPath().getList("details").size()).isEqualTo(addRefundsCount);
    }
}
