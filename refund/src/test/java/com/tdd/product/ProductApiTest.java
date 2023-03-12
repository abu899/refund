package com.tdd.product;

import com.tdd.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductApiTest extends ApiTest {

    @Test
    void productApi() {
        ProductDto productDto = ProductSteps.makeProductRequest();
        ExtractableResponse<Response> response = makeProductApiRequest(productDto);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private ExtractableResponse<Response> makeProductApiRequest(ProductDto productDto) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(productDto)
                .when()
                .post("/product")
                .then()
                .log().all().extract();
    }
}
