package com.example.rest_endpoint_rest_templates.controller;

import com.example.rest_endpoint_rest_templates.model.PaymentDetails;
import com.example.rest_endpoint_rest_templates.proxy.PaymentsProxy;

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

        return paymentsProxy.createPayment(paymentDetails);
    }
}
