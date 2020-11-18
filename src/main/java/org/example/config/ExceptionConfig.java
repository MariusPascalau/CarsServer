package org.example.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(CarException.class)
    public ResponseEntity parseBusinessException(CarException ex){
        Map<String,Object> responseMessage = new LinkedHashMap<>();
        responseMessage.put("status",ex.getStatus());
        responseMessage.put("message",ex.getMessage());

        return new ResponseEntity(responseMessage, HttpStatus.valueOf(ex.getStatus()));
    }
}
