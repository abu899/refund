package com.tdd.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @PostMapping("/shop")
    public ResponseEntity<Long> shop(@RequestBody CreateShopDto createShopDto) {
        Long shopId = shopService.createShop(createShopDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(shopId);
    }
}
