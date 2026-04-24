package com.botica.botica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.servlet.http.HttpServletRequest; // Para URL
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationExceptions(
            MethodArgumentNotValidException ex, 
            HttpServletRequest request) { // Añadimos el request aquí
        
        Map<String, String> errors = new HashMap<>();
        
        // extraer cada error de validación ("stock, no es negativo")
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage())
        );

       
        return new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            "Bad Request",
            "Existen errores en los datos enviados",
            request.getRequestURI(), // Captura la URL 
            errors
        );
    }
}