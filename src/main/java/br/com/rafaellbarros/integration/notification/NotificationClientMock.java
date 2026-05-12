package br.com.rafaellbarros.integration.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConditionalOnProperty(name = "integration.notification.mode", havingValue = "mock", matchIfMissing = true)
public class NotificationClientMock implements NotificationClient {
    
    @Override
    public void notifyOrderCreated(Long userId, Long orderId) {
        log.info("📧 [MOCK] Email sent to user {}: Order {} created successfully", userId, orderId);
        log.info("   Subject: Order Confirmation - #{}", orderId);
        log.info("   Body: Your order has been received and is being processed.");
    }
    
    @Override
    public void notifyPaymentApproved(Long userId, Long orderId, String transactionId) {
        log.info("📧 [MOCK] Email sent to user {}: Payment approved for order {}", userId, orderId);
        log.info("   Transaction ID: {}", transactionId);
        log.info("   Body: Your payment has been approved. Order will be shipped soon.");
    }
    
    @Override
    public void notifyOrderShipped(Long orderId, String trackingCode) {
        log.info("📧 [MOCK] Email sent: Order {} shipped. Tracking: {}", orderId, trackingCode);
    }
}