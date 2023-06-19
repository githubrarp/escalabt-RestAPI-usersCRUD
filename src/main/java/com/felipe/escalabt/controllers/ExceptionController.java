package com.felipe.escalabt.controllers;

import com.felipe.escalabt.utils.customexceptions.MyResourceNotFoundException;
import com.felipe.escalabt.utils.customexceptions.MyUserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request){
        e.printStackTrace();

        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.put("mensaje", "mensaje de error");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MyResourceNotFoundException.class)
    public ResponseEntity<Object> handleMyResourceNotFoundException(Exception e, WebRequest request){
        e.printStackTrace();

        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("mensaje", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MyUserAlreadyExistException.class, IllegalArgumentException.class})
    public ResponseEntity<Object> handleMyUserAlreadyExistException(Exception e, WebRequest request){
        e.printStackTrace();

        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("mensaje", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
