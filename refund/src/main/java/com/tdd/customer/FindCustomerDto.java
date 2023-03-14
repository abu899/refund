package com.tdd.customer;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
class FindCustomerDto {
    private String encPassportNum;

    public FindCustomerDto(String encPassportNum) {
        this.encPassportNum = encPassportNum;
    }
}
