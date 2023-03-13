package com.tdd.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nation;
    private String passportNum;

    public Customer(String name, String nation, String passportNum) {
        Assert.hasText(name, "Customer Name is mandatory");
        Assert.hasText(nation, "Nation is mandatory");
        Assert.isTrue(nation.length() == 3, "Nation code length is 3");
        Assert.hasText(passportNum, "Passport Number is mandatory");
        Assert.isTrue(passportNum.length() == 8, "Passport number is not valid");

        this.name = name;
        this.nation = nation;
        this.passportNum = passportNum;
    }
}
