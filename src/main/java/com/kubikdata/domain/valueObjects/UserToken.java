package com.kubikdata.domain.valueObjects;

public class UserToken {
    private String token;

    public UserToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return token;
    }
}
