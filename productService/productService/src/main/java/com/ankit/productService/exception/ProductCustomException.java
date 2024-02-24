package com.ankit.productService.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductCustomException extends  RuntimeException{
    private String errorCode;

    public ProductCustomException(String msg, String errorCode){
        super(msg);
        this.errorCode=errorCode;
    }
}
