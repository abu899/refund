package com.tdd.customer;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomerDto {
    private String name;
    private String nation;
    private String encPassportNum;

    public CustomerDto(String name, String nation, String encPassportNum) {
        this.name = name;
        this.nation = nation;
        this.encPassportNum = encPassportNum;
    }
}
