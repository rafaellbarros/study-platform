package br.com.rafaellbarros.integration.invetory;

public record ReservedItem(Long productId, Integer quantity, boolean available) {}