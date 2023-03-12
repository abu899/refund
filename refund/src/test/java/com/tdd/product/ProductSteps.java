package com.tdd.product;

public interface ProductSteps {
    static ProductDto makeProductRequest() {
        String productName = "productName";
        int price = 30000;
        ProductCategory productCategory = ProductCategory.SHOES;
        return new ProductDto(productName, price, productCategory);
    }
}
