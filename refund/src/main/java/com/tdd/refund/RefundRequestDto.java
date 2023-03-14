package com.tdd.refund;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RefundRequestDto {
    private int price;
    private ProductCategory productCategory;
    private String encPassportNum;

    public RefundRequestDto(int price, ProductCategory productCategory, String encPassportNum) {
        this.price = price;
        this.productCategory = productCategory;
        this.encPassportNum = encPassportNum;
    }
}
