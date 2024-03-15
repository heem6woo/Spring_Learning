package com.heem.cruddemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> exceptionHandler(Exception ex) {

        EmployeeErrorResponse eer = new EmployeeErrorResponse();
        eer.setStatus(HttpStatus.BAD_REQUEST.value());
        eer.setMsg(ex.getMessage());
        eer.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(eer, HttpStatus.BAD_REQUEST);

    }
}
