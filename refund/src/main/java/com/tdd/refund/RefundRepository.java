package com.tdd.refund;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefundRepository extends JpaRepository<Refund, Long> {
    @Query(value = "select r from Refund r join fetch r.customer c where c.passportNum = :decPassportNum")
    Optional<Refund> findByDecPassportNum(@Param("decPassportNum") String decPassportNum);
}