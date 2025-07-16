package com.example.rest_endpoint_rest_templates.proxy;

import com.example.rest_endpoint_rest_templates.model.PaymentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class PaymentsProxy {

    @Autowired
    private RestTemplate rest;

    @Value("${name.service.url}")
    private String paymentServiceUrl;

    public PaymentDetails createPayment(PaymentDetails paymentDetails) {
        String uri = paymentServiceUrl + "/payment";

        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId",
                UUID.randomUUID().toString());

        HttpEntity<PaymentDetails> httpEntity = new HttpEntity<>(paymentDetails, headers);

        ResponseEntity<PaymentDetails> response =
                rest.exchange(uri,
                        HttpMethod.POST,
                        httpEntity,
                        PaymentDetails.class);

        return response.getBody();
    }
}
