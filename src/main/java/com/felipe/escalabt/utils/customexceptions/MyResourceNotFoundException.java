package com.felipe.escalabt.utils.customexceptions;

public class MyResourceNotFoundException extends RuntimeException{
    public MyResourceNotFoundException(String message) {
        super(message);
    }
}
