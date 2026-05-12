package br.com.rafaellbarros.integration.invetory;

import br.com.rafaellbarros.order.application.dto.OrderItemInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@ConditionalOnProperty(name = "integration.inventory.mode", havingValue = "mock", matchIfMissing = true)
public class InventoryClientMock implements InventoryClient {
    
    @Override
    public StockReserveResponse reserveStock(Long orderId, List<OrderItemInput> items) {
        log.info("🔧 [MOCK] Reserving stock for order: {}", orderId);
        
        List<ReservedItem> reservedItems = items.stream()
            .map(item -> new ReservedItem(item.getProductId(), item.getQuantity(), true))
            .collect(Collectors.toList());
        
        log.info("✅ [MOCK] Stock reserved for order: {} - Items: {}", orderId, items.size());
        
        return new StockReserveResponse(true, "Stock reserved successfully", reservedItems);
    }
    
    @Override
    public void confirmStock(Long orderId) {
        log.info("✅ [MOCK] Stock confirmed for order: {}", orderId);
    }
    
    @Override
    public void releaseStock(Long orderId) {
        log.info("🔄 [MOCK] Stock released for order: {}", orderId);
    }
}