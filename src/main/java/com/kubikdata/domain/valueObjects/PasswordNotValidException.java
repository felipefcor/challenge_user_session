package com.kubikdata.domain.valueObjects;

public class PasswordNotValidException extends RuntimeException{

    String message = "password not valid";

    public String getMessage() {
        return message;
    }
}

