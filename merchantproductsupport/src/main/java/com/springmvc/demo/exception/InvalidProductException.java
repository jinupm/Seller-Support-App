package com.springmvc.demo.exception;

public class InvalidProductException extends RuntimeException{

    public InvalidProductException(String errorMessage){
            super(errorMessage);
    }

}
