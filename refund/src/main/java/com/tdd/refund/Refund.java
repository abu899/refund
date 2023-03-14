package com.tdd.refund;

import com.tdd.customer.Customer;
import com.tdd.shop.Shop;
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
    private RefundStatus refundStatus;
    @OneToOne(fetch = FetchType.LAZY)
    private Customer customer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public Refund(int price, ProductCategory productCategory, double refundCost, Customer customer) {
        Assert.isTrue(price >= 30000, "Price should be 30000");
        Assert.notNull(productCategory, "Product category is mandatory");
        Assert.isTrue(refundCost < 30000, "refund cost is not bigger than price");
        Assert.notNull(customer, "customer is mandatory");

        this.price = price;
        this.productCategory = productCategory;
        this.refundCost = refundCost;
        this.refundType = price < 500000 ? RefundType.IMMEDIATE_REFUND : RefundType.AFTER_REFUND;
        this.customer = customer;
        this.refundStatus = refundType == RefundType.IMMEDIATE_REFUND ? RefundStatus.APPROVE : RefundStatus.PRE_APPROVE;
    }
}
