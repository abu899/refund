package shop;

import com.tdd.shop.CreateShopDto;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class ShopSteps {
    public static CreateShopDto createShopRequest() {
        String name = "TestShop";
        String address = "Seoul";
        return new CreateShopDto(name, address);
    }

    public static ExtractableResponse<Response> createShopApiRequest(CreateShopDto createShopDto) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(createShopDto)
                .when()
                .post("/shop")
                .then()
                .log().all().extract();
    }

    public static ExtractableResponse<Response> makeShopFindApiRequest(Long shopId) {
        return RestAssured.given().log().all()
                .pathParam("shopId", shopId)
                .when()
                .get("/refund/{shopId}")
                .then()
                .log().all().extract();
    }
}
