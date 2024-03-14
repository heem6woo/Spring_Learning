package com.heem.crud.rest;

import com.heem.crud.dao.StudentDao;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String msg) {
        super(msg);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
