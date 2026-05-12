package br.com.rafaellbarros.integration.payment;

public record PaymentResponse(
    boolean success,
    String transactionId,
    String message
) {
    // Records já criam automaticamente os métodos: success(), transactionId(), message()

    // Você pode adicionar métodos auxiliares
    public boolean isSuccess() {
        return success;
    }

    public static PaymentResponse approved(String transactionId) {
        return new PaymentResponse(true, transactionId, "Payment approved");
    }

    public static PaymentResponse failed(String message) {
        return new PaymentResponse(false, null, message);
    }
}