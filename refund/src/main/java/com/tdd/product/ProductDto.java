package com.tdd.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto extends Product {
    private String productName;
    private int price;
    private ProductCategory productCategory;
}

