package com.example.restfull.books.restbooks.model.error;


public class ErrorResponse {


    private ErrorInfo errorInfo;

    public ErrorResponse(){}

    public ErrorResponse(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }
}
