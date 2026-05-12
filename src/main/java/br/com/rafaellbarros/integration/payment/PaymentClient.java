package br.com.rafaellbarros.integration.payment;


import br.com.rafaellbarros.order.application.dto.PaymentRequest;

public interface PaymentClient {
    PaymentResponse processPayment(Long orderId, PaymentRequest request);
}


