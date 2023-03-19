package com.tdd.shop;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ShopRefundResponse {
    private int totalPrice;
    private double totalRefund;
    List<ShopRefundResponseDetailDto> details;

    @Getter
    @Builder
    static class ShopRefundResponseDetailDto {
        private int price;
        private double refund;
        private String encPassportNum;
    }
}
