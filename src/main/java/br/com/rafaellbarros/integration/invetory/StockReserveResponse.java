package br.com.rafaellbarros.integration.invetory;

import java.util.List;

public record StockReserveResponse(boolean success, String message, List<ReservedItem> reservedItems) {}