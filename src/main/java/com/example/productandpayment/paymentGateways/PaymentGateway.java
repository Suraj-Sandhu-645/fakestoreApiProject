package com.example.productandpayment.paymentGateways;

import com.razorpay.RazorpayException;

public interface PaymentGateway {
    String generatePaymentLink(Long order_id, Long amount, String phoneNumber) throws RazorpayException;
}
