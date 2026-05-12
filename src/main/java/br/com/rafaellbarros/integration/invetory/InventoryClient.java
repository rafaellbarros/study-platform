package br.com.rafaellbarros.integration.invetory;



import br.com.rafaellbarros.order.application.dto.OrderItemInput;

import java.util.List;

public interface InventoryClient {
    StockReserveResponse reserveStock(Long orderId, List<OrderItemInput> items);
    void confirmStock(Long orderId);
    void releaseStock(Long orderId);
}
