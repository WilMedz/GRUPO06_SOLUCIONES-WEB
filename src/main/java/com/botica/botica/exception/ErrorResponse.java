package com.botica.botica.exception;

import java.time.LocalDateTime;
import java.util.Map;
import lombok.Data;

@Data
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private Map<String, String> errors; // Aquí guardaremos qué campo falló (ej: "stock")

    public ErrorResponse(int status, String message, Map<String, String> errors) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
}