package br.com.rafaellbarros.integration.payment;

import br.com.rafaellbarros.order.application.dto.PaymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConditionalOnProperty(name = "integration.payment.mode", havingValue = "mock", matchIfMissing = true)
public class PaymentClientMock implements PaymentClient {
    
    private int failureCounter = 0;
    
    @Override
    public PaymentResponse processPayment(Long orderId, PaymentRequest request) {
        log.info("🔧 [MOCK] Processing payment for order: {}", orderId);
        log.info("   Amount: {}, Card: {}", request.amount(), maskCardNumber(request.cardNumber()));
        
        // Simula validação
        if (request.amount() == null || request.amount().doubleValue() <= 0) {
            log.warn("❌ [MOCK] Invalid amount for order: {}", orderId);
            return PaymentResponse.failed("Invalid amount");
        }
        
        // Simula falha de 20% para testes (opcional)
        if (shouldFailRandomly()) {
            log.warn("❌ [MOCK] Random failure for order: {}", orderId);
            return PaymentResponse.failed("Random payment failure");
        }
        
        // Mock de sucesso
        String transactionId = "MOCK_TXN_" + System.currentTimeMillis() + "_" + orderId;
        log.info("✅ [MOCK] Payment approved for order: {}, transaction: {}", orderId, transactionId);
        
        return PaymentResponse.approved(transactionId);
    }
    
    private String maskCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 4) return "****";
        return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
    }
    
    private boolean shouldFailRandomly() {
        // Falha 20% das vezes a cada 5 chamadas
        failureCounter++;
        if (failureCounter >= 5) {
            failureCounter = 0;
            return true;
        }
        return false;
    }
}