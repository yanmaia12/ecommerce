package com.yanmaia12.ecommerce.exception;

public class AcessDeniedException extends RuntimeException{
    public AcessDeniedException(String message){
        super(message);
    }
}
