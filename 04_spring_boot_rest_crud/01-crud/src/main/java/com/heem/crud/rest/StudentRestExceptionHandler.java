package com.heem.crud.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    // add exception handler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> notFoundExceptionHandler(StudentNotFoundException ex) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> exceptionHandler(Exception ex) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
