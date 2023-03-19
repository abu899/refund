package com.tdd.shop;

import com.tdd.refund.Refund;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public ShopRefundResponse findRefunds(Long shopId) {
        Shop shop = shopRepository.findWithRefunds(shopId)
                .orElseThrow(IllegalArgumentException::new);
        List<Refund> refunds = shop.getRefunds();

        int priceSum = refunds.stream().mapToInt(Refund::getPrice).sum();
        double refundSum = refunds.stream().mapToDouble(Refund::getRefundCost).sum();
        List<ShopRefundResponse.ShopRefundResponseDetailDto> details = refunds.stream()
                .map(r -> ShopRefundResponse.ShopRefundResponseDetailDto.builder()
                        .price(r.getPrice())
                        .refund(r.getRefundCost())
                        .encPassportNum(r.getCustomer().getPassportNum())
                        .build())
                .collect(Collectors.toList());

        return ShopRefundResponse.builder()
                .totalPrice(priceSum)
                .totalRefund(refundSum)
                .details(details)
                .build();

    }
}
