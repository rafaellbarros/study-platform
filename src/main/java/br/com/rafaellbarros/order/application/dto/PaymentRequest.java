package br.com.rafaellbarros.order.application.dto;

import java.math.BigDecimal;

public record PaymentRequest(
    BigDecimal amount,
    String cardNumber,
    String cvv,
    String cardHolderName
) {}