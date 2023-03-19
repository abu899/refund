package com.tdd.refund;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RefundController {

    private final RefundService refundService;

    @PostMapping("/refund")
    public ResponseEntity<Void> refund(@RequestBody RefundRequestDto requestDto) {
        refundService.addRefund(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/refund")
    public ResponseEntity<List<RefundResponseDto>> refund(@RequestParam String encPassportNum) {
        List<RefundResponseDto> response = refundService.findRefundByPassportNum(encPassportNum);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cancel")
    public ResponseEntity<RefundCancelDto> cancel(@RequestParam Long refundId) {
        RefundCancelDto cancelDto = refundService.cancel(refundId);
        return ResponseEntity.ok(cancelDto);
    }
}
