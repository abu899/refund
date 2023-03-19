package com.tdd.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    @Query(value = "select s from Shop s join fetch s.refunds r join fetch r.customer where s.id = :shopId")
    Optional<Shop> findWithRefunds(@Param("shopId") Long shopId);
}
