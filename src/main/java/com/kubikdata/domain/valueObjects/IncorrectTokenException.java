package com.kubikdata.domain.valueObjects;

public class IncorrectTokenException extends RuntimeException {
    String message = "token not valid";

    public String getMessage() {
        return message;
    }

}
