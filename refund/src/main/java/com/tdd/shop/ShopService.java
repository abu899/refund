package com.tdd.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShopService {
    private final ShopRepository shopRepository;

    public void createShop(CreateShopDto createShopDto) {
        Shop shop = new Shop(createShopDto.getName(), createShopDto.getAddress());
        shopRepository.save(shop);
    }
}
