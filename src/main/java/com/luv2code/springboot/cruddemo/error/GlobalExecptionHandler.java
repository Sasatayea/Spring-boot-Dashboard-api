package com.luv2code.springboot.cruddemo.error;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExecptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(RecoredNotFoundExecption.class)
    public ResponseEntity<?> handleRecoredNotFound(RecoredNotFoundExecption ex){

        ErrorResponse error = new ErrorResponse(ex.getLocalizedMessage(), Arrays.asList(ex.getMessage()));
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);

    }


    @ExceptionHandler(DaplicateRecoredException.class)
    public ResponseEntity<?> DaplicateRecoredException(DaplicateRecoredException ex){

        ErrorResponse error = new ErrorResponse(ex.getLocalizedMessage(), Arrays.asList(ex.getMessage()));
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error);



    }
}
