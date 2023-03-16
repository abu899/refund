package com.tdd.refund;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RefundRequestDto {
    private Long shopId;
    private int price;
    private ProductCategory productCategory;
    private String encPassportNum;
}
