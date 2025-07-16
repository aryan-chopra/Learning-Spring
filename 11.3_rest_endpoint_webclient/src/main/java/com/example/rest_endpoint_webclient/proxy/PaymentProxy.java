package com.example.rest_endpoint_webclient.proxy;

import com.example.rest_endpoint_webclient.model.PaymentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Component
public class PaymentProxy {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private WebClient webClient;

    @Value("${name.service.url}")
    private String url;

    public Mono<PaymentDetails> createPayment(
            String requestId,
            PaymentDetails paymentDetails
    ) {
        logger.info("Request Id in proxy: " + requestId);

        Mono<PaymentDetails> mono = webClient.post()
                .uri(url + "/payment")
                .header("requestId", requestId)
                .body(Mono.just(paymentDetails), PaymentDetails.class)
                .retrieve()
                .bodyToMono(PaymentDetails.class);

        logger.info("Mono: " + mono.block().getId());

        return mono;
    }
}
