package com.ankit.productService.exception;

import com.ankit.productService.model.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ProductCustomException.class)
    public ResponseEntity<ExceptionResponse> handleProductServiceException(ProductCustomException exception) {
        return new ResponseEntity<>(new ExceptionResponse(exception.getMessage(), exception.getErrorCode()), HttpStatus.NOT_FOUND);
    }
}
