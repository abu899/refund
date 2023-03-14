package com.tdd.refund;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RefundResponseDto {
    Long refundId;
    int price;
    double refundCost;
}
