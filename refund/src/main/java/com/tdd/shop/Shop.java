package com.tdd.shop;

import com.tdd.refund.Refund;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Shop {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "shop")
    private List<Refund> refunds;


    public Shop(String name, String address) {
        Assert.hasText(name, "Shop name is mandatory");
        Assert.hasText(address, "Shop address is mandatory");

        this.name = name;
        this.address = address;
    }
}
