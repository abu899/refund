package com.tdd.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void addProduct(ProductDto productDto) {
        Product product = new Product(productDto.getProductName(), productDto.getPrice(), productDto.getProductCategory());
        productRepository.save(product);
    }
}
