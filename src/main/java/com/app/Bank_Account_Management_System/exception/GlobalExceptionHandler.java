package com.app.Bank_Account_Management_System.exception;

import com.app.Bank_Account_Management_System.dto.MessageDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MessageDTO> resourceNotFoundExceptionHandle(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND) .body(new MessageDTO(ex.getMessage()));
    }
    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<MessageDTO> InsufficientBalanceException(InsufficientBalanceException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageDTO(ex.getMessage()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(error.getField(),
                                error.getDefaultMessage()));

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", 400);
        response.put("message", "Validation Failed");
        response.put("errors", errors);

        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST
        );
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<MessageDTO> handleInvalidEnum(HttpMessageNotReadableException ex) {

        String message = ex.getMostSpecificCause().getMessage();
        if (message.contains("AccountType")) {
            return ResponseEntity.badRequest().body(
                    new MessageDTO(
                            "Invalid AccountType! Allowed values: SAVINGS, FIXED_DEPOSIT, CURRENT"
                    )
            );
        }

        if (message.contains("TransactionType")) {
            return ResponseEntity.badRequest().body(
                    new MessageDTO(
                            "Invalid TransactionType! Allowed values: DEPOSIT, WITHDRAW"
                    )
            );
        }

        return ResponseEntity.badRequest().body(
                new MessageDTO("Malformed JSON request")
        );
    }
}
