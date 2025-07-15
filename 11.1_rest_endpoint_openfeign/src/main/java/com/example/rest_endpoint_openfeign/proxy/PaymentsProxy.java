package com.example.rest_endpoint_openfeign.proxy;

import com.example.rest_endpoint_openfeign.model.PaymentDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "PaymentsProxy",
        url = "${name.service.url}")
public interface PaymentsProxy {

    @PostMapping("/payment")
    PaymentDetails createPayment(
            @RequestHeader("requestId") String requestId,
            @RequestBody PaymentDetails paymentDetails
    );
}
