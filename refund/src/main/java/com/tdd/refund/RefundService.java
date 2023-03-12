package com.tdd.refund;

import org.springframework.stereotype.Service;

@Service
public class RefundService {
    public void validatePassport(String nation) {
        // 통신을 통해 데이터를 유효성 검토
        if (nation.length() != 3) {
            throw new IllegalArgumentException("passport is not valid");
        }
    }
}
