package com.example.rest_endpoint_openfeign.controller;

import com.example.rest_endpoint_openfeign.model.PaymentDetails;
import com.example.rest_endpoint_openfeign.proxy.PaymentsProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentsController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private PaymentsProxy paymentsProxy;

    @PostMapping("/payment")
    public PaymentDetails createPayment(
            @RequestBody PaymentDetails paymentDetails
    ) {
        logger.info("Got payment of amount: " + paymentDetails.getAmount());

        String requestId = UUID.randomUUID().toString();
        return paymentsProxy.createPayment(requestId, paymentDetails);
    }
}
