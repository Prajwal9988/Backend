package com.kinara.exception;


import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DefaultException.class)
    public ResponseEntity<Object> handleDefaultException (DefaultException e){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        log.error(e.getMessage());
        ApiExceptionTemplate exceptionTemplate = new ApiExceptionTemplate(
                e.getMessage(),
                httpStatus,
                LocalDateTime.now().toString()
        );
        return new ResponseEntity<>(exceptionTemplate, httpStatus);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException (BadRequestException e){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ApiExceptionTemplate exceptionTemplate = new ApiExceptionTemplate(
                e.getMessage(),
                httpStatus,
                LocalDateTime.now().toString()
        );
        return new ResponseEntity<>(exceptionTemplate, httpStatus);
    }
}
