package com.tdd.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {
    @Autowired private ProductService productService;

    @Test
    void product() {
        ProductDto productDto = ProductSteps.makeProductRequest();
        productService.addProduct(productDto);
    }
}
