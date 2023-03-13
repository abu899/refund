package com.tdd.refund;

import com.tdd.customer.Customer;
import com.tdd.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefundService {
    private final RefundRepository refundRepository;
    private final CustomerRepository customerRepository;

    public void validatePassport(String nation) {
        // 통신을 통해 데이터를 유효성 검토
        if (nation.length() != 3) {
            throw new IllegalArgumentException("passport is not valid");
        }
    }

    public void addRefund(RefundRequestDto refundDto) {
        Customer customer = customerRepository.findByPassportNum(refundDto.getPassportNumber())
                .orElseThrow(IllegalArgumentException::new);
        double refundCost = refundDto.getPrice() * 0.1;
        RefundType refundType = checkRefundType(refundDto.getPrice());
        Refund refund = new Refund(refundDto.getPrice(), refundDto.getProductCategory(), refundCost, refundType, customer);
        refundRepository.save(refund);
    }

    private RefundType checkRefundType(int price) {
        return price < 500000 ? RefundType.IMMEDIATE_REFUND : RefundType.AFTER_REFUND;
    }
}
