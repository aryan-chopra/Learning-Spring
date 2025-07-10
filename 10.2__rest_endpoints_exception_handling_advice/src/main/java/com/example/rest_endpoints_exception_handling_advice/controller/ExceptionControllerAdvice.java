package com.example.rest_endpoints_exception_handling_advice.controller;

import com.example.rest_endpoints_exception_handling_advice.error.MissingPlayerNameException;
import com.example.rest_endpoints_exception_handling_advice.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MissingPlayerNameException.class)
    public ResponseEntity<ErrorDetails> exceptionMissingPlayerName() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Player name is missing");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
