package br.com.rafaellbarros.user.domain.valueobject;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Email {

    private final String value;

    public Email(String value) {

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null");
        }

        if (!value.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email");
        }

        this.value = value.toLowerCase().trim();
    }

    @Override
    public String toString() {
        return value;
    }
}