package com.ankit.order.external.decoder;

import com.ankit.order.exception.CustomException;
import com.ankit.order.external.response.ExceptionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        log.info(response.request().url());
        log.info(response.request().headers());
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ExceptionResponse exceptionResponse = objectMapper.readValue(response.body().asInputStream(), ExceptionResponse.class);
            return new CustomException(exceptionResponse.getMsg(),
                    exceptionResponse.getErrorCode(),response.status());
        } catch (IOException e) {
            return new CustomException("Internal server Error",
                    "Internal server Error",500);
        }
    }
}
