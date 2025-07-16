package com.example.rest_endpoint_webclient.controller;

import com.example.rest_endpoint_webclient.model.PaymentDetails;
import com.example.rest_endpoint_webclient.proxy.PaymentProxy;
import org.apache.juli.logging.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(PaymentController.class);
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private PaymentProxy paymentProxy;

    @PostMapping("/payment")
    public Mono<PaymentDetails> createPayment(
            @RequestBody PaymentDetails paymentDetails
    ) {
        String requestId = UUID.randomUUID().toString();

        logger.info("Request Id: " + requestId);

        return paymentProxy.createPayment(requestId, paymentDetails);
    }
}
