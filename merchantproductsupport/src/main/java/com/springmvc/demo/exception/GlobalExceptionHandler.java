package com.springmvc.demo.exception;

import com.springmvc.demo.model.ErrorDetails;
import com.springmvc.demo.model.ErrorModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Objects;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);

    }

/*    @ExceptionHandler(InvalidProductException.class)
    public ResponseEntity<ErrorModel> handleInvalidApiException(InvalidProductException e) {
//        ErrorModel errorModel = new ErrorModel(101, e.getMessage());
                ErrorModel errorModel = ErrorModel.builder()
                        .errorCode(400)
                        .errorMessage(e.getMessage())
                        .build();
                return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
            }*/

    //Overriding method argument not valid to return exact issue causing the BAD REQUEST 400
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

/*        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(), request.getDescription(false));*/

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                "Total Errors " + ex.getErrorCount() + ", First Error : " + ex.getFieldError().getDefaultMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        //Here since we are overriding we cant use type as ErrorDetails we need to use that of the overriding method

    }

    }
