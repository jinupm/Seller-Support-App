package com.springmvc.demo.exception;

import com.springmvc.demo.model.ErrorDetails;
import com.springmvc.demo.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;


@ControllerAdvice
public class GlobalExceptionHandler {


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
    }
