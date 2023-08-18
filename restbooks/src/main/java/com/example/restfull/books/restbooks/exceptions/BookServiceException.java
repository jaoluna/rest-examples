package com.example.restfull.books.restbooks.exceptions;

public class BookServiceException extends RuntimeException{

    public BookServiceException(String message, Throwable throwable){
        super(message, throwable);
    }

}
