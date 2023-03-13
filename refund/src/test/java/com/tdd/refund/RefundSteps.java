package com.tdd.refund;

public class RefundSteps {
    public static RefundRequestDto makeRefundRequest() {
        int price = 30000;
        ProductCategory productCategory = ProductCategory.GLASSES;
        String passportNumber = "M431221";
        return new RefundRequestDto(price, productCategory, passportNumber);
    }
}
