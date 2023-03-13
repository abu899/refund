package com.tdd.refund;

import com.tdd.customer.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Refund {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int price;
    private double refundCost;
    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;
    @Enumerated(EnumType.STRING)
    private RefundType refundType;
    @OneToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public Refund(int price, ProductCategory productCategory, double refundCost, RefundType refundType, Customer customer) {
        Assert.isTrue(price >= 30000, "Price should be 30000");
        Assert.notNull(productCategory, "Product category is mandatory");
        Assert.isTrue(refundCost < 30000, "refund cost is not bigger than price");
        Assert.notNull(customer, "customer is mandatory");

        this.price = price;
        this.productCategory = productCategory;
        this.refundCost = refundCost;
        this.refundType = refundType;
        this.customer = customer;
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
