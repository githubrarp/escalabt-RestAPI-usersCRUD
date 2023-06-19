package com.felipe.escalabt.utils.customexceptions;

public class MyUserAlreadyExistException extends RuntimeException {

    public MyUserAlreadyExistException(String message) {
        super(message);
    }
}
