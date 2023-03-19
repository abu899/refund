package com.tdd.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @PostMapping("/shop")
    public ResponseEntity<Long> shop(@RequestBody CreateShopDto createShopDto) {
        Long shopId = shopService.createShop(createShopDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(shopId);
    }

    @GetMapping("/refund/{shopId}")
    public ResponseEntity<ShopRefundResponse> find(@PathVariable Long shopId) {
        ShopRefundResponse shopRefund = shopService.findRefunds(shopId);
        return ResponseEntity.ok(shopRefund);
    }
}
