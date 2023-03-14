package com.tdd.refund;

import com.tdd.customer.Customer;
import com.tdd.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefundService {
    private final RefundRepository refundRepository;
    private final CustomerService customerService;

    public void addRefund(RefundRequestDto refundDto) {
        Customer customer = customerService.findCustomerByPassport(refundDto.getEncPassportNum());
        double refundCost = refundDto.getPrice() * 0.1;
        Refund refund = new Refund(refundDto.getPrice(), refundDto.getProductCategory(), refundCost, customer);
        refundRepository.save(refund);
    }

    public RefundResponseDto findRefundByPassportNum(String encPassportNum) {
        Refund refund = refundRepository.findByEncPassportNum(encPassportNum)
                .orElseThrow(IllegalArgumentException::new);
        return new RefundResponseDto(refund.getId(), refund.getPrice(), refund.getRefundCost());
    }
}
