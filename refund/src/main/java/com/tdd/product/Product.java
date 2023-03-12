package com.tdd.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private int price;

    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    public Product(String productName, int price, ProductCategory productCategory) {
        Assert.hasText(productName, "Product name is mandatory");
        Assert.isTrue(price >= 30000, "Price should be 30000");
        Assert.notNull(productCategory, "Product category is mandatory");
        this.productName = productName;
        this.price = price;
        this.productCategory = productCategory;
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
