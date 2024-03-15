package com.heem.cruddemo.rest;

public class EmployeeException extends RuntimeException {

    public EmployeeException() {
    }

    public EmployeeException(String message) {
        super(message);
    }

    public EmployeeException(String message, Throwable cause) {
        super(message, cause);
    }
}
