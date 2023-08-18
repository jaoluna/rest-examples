package com.example.restfull.books.restbooks.controller;

import com.example.restfull.books.restbooks.exceptions.BookNotFoundException;
import com.example.restfull.books.restbooks.exceptions.BookServiceException;
import com.example.restfull.books.restbooks.model.error.ErrorInfo;
import com.example.restfull.books.restbooks.model.error.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomExceptionHandlerTest {


    private final CustomExceptionHandler exceptionHandler = new CustomExceptionHandler();


    @Test
    void whenHandleBookServiceExceptionThenReturnSuccess() {

        BookServiceException exception = new BookServiceException("Service exception message", new Exception());

        ResponseEntity<ErrorResponse> responseEntity = exceptionHandler.handleBookServiceException(exception);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Service exception message", Objects.requireNonNull(responseEntity.getBody()).getErrorInfo().getDetails());


    }

    @Test
    void handleBookNotFoundException() {

        BookNotFoundException exception = new BookNotFoundException("Service exception message");

        ResponseEntity<ErrorResponse> responseEntity = exceptionHandler.handleBookNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Service exception message", Objects.requireNonNull(responseEntity.getBody()).getErrorInfo().getDetails());


    }
}