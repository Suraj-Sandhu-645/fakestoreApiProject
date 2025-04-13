package com.example.productandpayment.controller;

import com.example.productandpayment.dtos.InitiatePaymentRequestDto;
import com.example.productandpayment.service.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto initiatePaymentRequestDto) throws RazorpayException {
        return paymentService.initiatePayment(
                initiatePaymentRequestDto.getOrderId(),
                initiatePaymentRequestDto.getAmount(),
                initiatePaymentRequestDto.getPhoneNumber());
    }

    @PostMapping("/webhook")
    public void triggerWebhook(){
        System.out.println("Webhook Triggered");
    }
}

