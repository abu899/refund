package com.tdd.shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.ShopSteps;

@SpringBootTest
public class ShopTest {
    @Autowired
    ShopService shopService;

    @Test
    void shop() {
        CreateShopDto createShopDto = ShopSteps.createShopRequest();
        shopService.createShop(createShopDto);
    }
}
