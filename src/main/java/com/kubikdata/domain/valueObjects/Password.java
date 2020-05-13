package com.kubikdata.domain.valueObjects;

public class Password {
    private String password;

    public Password(String password) {
        if(password.length()<8 || password.length()>16) throw new PasswordNotValidException();
        this.password = password;
    }
}
