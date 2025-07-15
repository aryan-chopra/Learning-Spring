package com.example.payment_service.controller;

import com.example.payment_service.model.PaymentDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> paymentController(
            @RequestHeader("requestId") String requestId,
            @RequestBody PaymentDetails paymentDetails
    ) {
        logger.info("Got request with id: " + requestId +
                " and amount: " + paymentDetails.getAmount());

        paymentDetails.setId(UUID.randomUUID().toString());

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId", requestId)
                .body(paymentDetails);
    }
}
