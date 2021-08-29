package com.exercise.reverse.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class AppExceptionAdvice {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<CustomErrorResponse> handleRuntimeExceptions(RuntimeException e) {
        log.error(String.valueOf(e.getCause()));
        log.error("Runtime Error :", e);
        CustomErrorResponse customErrorResponse = new CustomErrorResponse("ERROR", e.getMessage());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<CustomErrorResponse> handleConstraintViolationExceptions(ConstraintViolationException e) {
        log.error("Request Param Validation Error :", e);

        CustomErrorResponse customErrorResponse = new CustomErrorResponse("ERROR", e.getMessage());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
    }


}