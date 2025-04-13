package com.example.productandpayment.paymentGateways;

import org.springframework.stereotype.Service;

@Service
public class StripePaymentGateway implements PaymentGateway{
    @Override
    public String generatePaymentLink(Long id, Long amount, String phoneNumber) {
        return null;
    }
}
