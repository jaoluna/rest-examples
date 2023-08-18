package com.example.restfull.books.restbooks.model.error;

import org.springframework.http.HttpStatus;

public class ErrorInfo {

    private HttpStatus status;
    private String details;

    public ErrorInfo(){}

    public ErrorInfo(HttpStatus status, String details) {
        this.status = status;
        this.details = details;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
