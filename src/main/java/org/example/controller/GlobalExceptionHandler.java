package org.example.controller;

import org.example.exceprion.APIException;
import org.example.exceprion.ExceptionCause;
import org.example.exceprion.ExceptionDetails;
import org.example.exceprion.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDetails handleNotFoundValue(APIException exception) {
        return ExceptionDetails.builder()
                .message(exception.getMessage())
                .cause(ExceptionCause.NOT_FOUND_VALUE)
                .build();
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionDetails handleUncaughtException(Exception exception) {
        return ExceptionDetails.builder()
                .message(exception.getMessage())
                .cause(ExceptionCause.UNCAUGHT_EXCEPTION)
                .build();
    }
}
