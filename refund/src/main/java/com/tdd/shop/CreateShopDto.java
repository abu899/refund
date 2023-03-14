package com.tdd.shop;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateShopDto {
    private String name;
    private String address;

    public CreateShopDto(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
