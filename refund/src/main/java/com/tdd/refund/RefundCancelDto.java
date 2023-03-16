package com.tdd.refund;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RefundCancelDto {
    private Long refundId;
    private RefundStatus refundStatus;
}
