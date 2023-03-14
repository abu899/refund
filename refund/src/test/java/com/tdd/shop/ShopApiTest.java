package com.tdd.shop;

import com.tdd.ApiTest;
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

}
