package com.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception e){
        GlobalException globalException = GlobalException.builder()
                .message(e.getMessage())
                .timestamp(new Date())
                .build();

        return new ResponseEntity<>(globalException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e){
        GlobalException globalException = GlobalException.builder()
                .message(e.getMessage())
                .timestamp(new Date())
                .build();
        return new ResponseEntity<>(globalException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> handleUsernameNotFoundException(UsernameNotFoundException exception){
        GlobalException globalException = GlobalException.builder()
                .message(exception.getMessage())
                .timestamp(new Date())
                .build();
        return new ResponseEntity<>(globalException, HttpStatus.BAD_REQUEST);
    }

}
