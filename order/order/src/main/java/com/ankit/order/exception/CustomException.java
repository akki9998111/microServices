package com.ankit.order.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomException extends  RuntimeException{
    private String errorCode;
    private int status;

    public CustomException(String msg, String errorCode, int status){
        super(msg);
        this.errorCode=errorCode;
        this.status = status;
    }
}
