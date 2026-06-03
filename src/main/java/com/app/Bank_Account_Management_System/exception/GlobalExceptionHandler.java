package com.app.Bank_Account_Management_System.exception;

import com.app.Bank_Account_Management_System.dto.MessageDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MessageDTO> resourceNotFoundExceptionHandle(ResourceNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND) .body(new MessageDTO(ex.getMessage()));
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<MessageDTO> badRequestExceptionHandle(BadRequestException ex){
        return ResponseEntity .status(HttpStatus.BAD_REQUEST) .body(new MessageDTO(ex.getMessage()));
    }
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<MessageDTO> conflictExceptionHandle(ConflictException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new MessageDTO(
                        ex.getMessage()
                ));
    }
}
