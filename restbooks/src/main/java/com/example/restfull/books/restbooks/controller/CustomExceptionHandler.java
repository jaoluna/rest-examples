package com.example.restfull.books.restbooks.controller;


import com.example.restfull.books.restbooks.exceptions.BookNotFoundException;
import com.example.restfull.books.restbooks.exceptions.BookServiceException;
import com.example.restfull.books.restbooks.model.error.ErrorInfo;
import com.example.restfull.books.restbooks.model.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(BookServiceException.class)
    public ResponseEntity<ErrorResponse> handleBookServiceException(BookServiceException exception){

        ErrorInfo info = new ErrorInfo(HttpStatus.NOT_FOUND, exception.getMessage());
        ErrorResponse response = new ErrorResponse(info);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }


    @ExceptionHandler({BookNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException exception){

        ErrorInfo info = new ErrorInfo(HttpStatus.NOT_FOUND, exception.getMessage());
        ErrorResponse response = new ErrorResponse(info);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }




}
