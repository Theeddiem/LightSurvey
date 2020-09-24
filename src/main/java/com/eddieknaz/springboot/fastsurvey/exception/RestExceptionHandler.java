package com.eddieknaz.springboot.fastsurvey.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorDetails> handleNotFoundException(NotFoundException ex)
    {
        ErrorDetails error = new ErrorDetails(HttpStatus.NOT_FOUND.value(),ex.getMessage(),new Date());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDetails> handleBadRequestException(BadRequestException ex)
    {
        ErrorDetails error = new ErrorDetails(HttpStatus.BAD_REQUEST.value(),ex.getMessage(),new Date());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
