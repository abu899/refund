package com.tdd.refund;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RefundController {

    private final RefundService refundService;

    @PostMapping("/refund")
    public ResponseEntity<Void> refund(@RequestBody RefundRequestDto requestDto) {
        refundService.addRefund(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
