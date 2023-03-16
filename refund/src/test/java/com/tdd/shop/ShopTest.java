package com.tdd.shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.ShopSteps;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ShopTest {
    @Autowired
    ShopService shopService;

    @Test
    void shop() {
        CreateShopDto createShopDto = ShopSteps.createShopRequest();
        shopService.createShop(createShopDto);
    }

    @Test
    void find() {
        CreateShopDto createShopDto = ShopSteps.createShopRequest();
        Long shopId = shopService.createShop(createShopDto);

        Shop findShop = shopService.findShopById(shopId);

        assertThat(shopId).isEqualTo(findShop.getId());
        assertThat(createShopDto.getName()).isEqualTo(findShop.getName());
        assertThat(createShopDto.getAddress()).isEqualTo(findShop.getAddress());
    }
}
