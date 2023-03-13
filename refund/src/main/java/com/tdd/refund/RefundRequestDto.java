package com.tdd.refund;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RefundRequestDto {
    private int price;
    private ProductCategory productCategory;
    private String passportNumber;

    public RefundRequestDto(int price, ProductCategory productCategory, String passportNum) {
        this.price = price;
        this.productCategory = productCategory;
        this.passportNumber = passportNum;
    }
}
