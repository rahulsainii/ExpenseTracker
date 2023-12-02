package com.contact.manager.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExpenseNotFoundException.class)
    public ResponseEntity<ErrorObject> handleExpenseNotFoundException(ExpenseNotFoundException ex, WebRequest request){

        ErrorObject er = new ErrorObject();
        er.setMessage(ex.getMessage());
        er.setStatusCode(HttpStatus.NOT_FOUND.value());
        er.setTimeStamp(new Date());
        return new ResponseEntity<ErrorObject>(er, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorObject> handleBadRequestException(MethodArgumentTypeMismatchException ex, WebRequest request){
        ErrorObject er = new ErrorObject();
        er.setMessage(ex.getMessage());
        er.setStatusCode(HttpStatus.BAD_REQUEST.value());
        er.setTimeStamp(new Date());
        return new ResponseEntity<ErrorObject>(er, HttpStatus.BAD_REQUEST);
    }
}
