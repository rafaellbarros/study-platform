package br.com.rafaellbarros.integration.notification;

public interface NotificationClient {
    void notifyOrderCreated(Long userId, Long orderId);
    void notifyPaymentApproved(Long userId, Long orderId, String transactionId);
    void notifyOrderShipped(Long orderId, String trackingCode);
}