package br.com.rafaellbarros.order.domain.exception;

public class OrderBusinessException extends RuntimeException {
    
    private final String code;
    
    public OrderBusinessException(String message) {
        super(message);
        this.code = "ORDER_ERROR";
    }
    
    public OrderBusinessException(String message, String code) {
        super(message);
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }
}