package com.tdd.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ShopService {
    private final ShopRepository shopRepository;

    @Transactional
    public Long createShop(CreateShopDto createShopDto) {
        Shop shop = new Shop(createShopDto.getName(), createShopDto.getAddress());
        Shop savedShop = shopRepository.save(shop);
        return savedShop.getId();
    }

    public Shop findShopById(Long shopId) {
        return shopRepository.findById(shopId)
                .orElseThrow(IllegalArgumentException::new);
    }
}
