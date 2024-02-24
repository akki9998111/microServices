package com.ankit.order.exception;

import com.ankit.order.external.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> handleCustomExceptionException(CustomException exception) {
        return new ResponseEntity<>(new ExceptionResponse(exception.getMessage(), exception.getErrorCode()), HttpStatus.valueOf(exception.getStatus()));
    }
}
