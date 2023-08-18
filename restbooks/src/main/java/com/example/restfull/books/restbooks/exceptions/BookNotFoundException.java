package com.example.restfull.books.restbooks.exceptions;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String message){
        super(message);
    }

}
