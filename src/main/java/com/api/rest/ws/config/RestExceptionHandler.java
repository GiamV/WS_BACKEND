package com.api.rest.ws.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.rest.ws.dto.ErrorDto;
import com.api.rest.ws.exceptions.AppException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppException ex) {
        // Usando el constructor tradicional en lugar de builder()
        ErrorDto errorDto = new ErrorDto(ex.getMessage());
        return ResponseEntity.status(ex.getCode())
            .body(errorDto);
    }
}
