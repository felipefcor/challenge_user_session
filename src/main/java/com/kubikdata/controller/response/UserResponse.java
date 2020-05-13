package com.kubikdata.controller.response;

import java.time.LocalDate;

/**
 * This object will encapsulate required fields to know user , token and date.
 */
public class UserResponse {

    private String username;
    private String token;
    private LocalDate date;

    public UserResponse(String username, String token, LocalDate date) {
        this.username = username;
        this.token = token;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }

    public LocalDate getDate() {
        return date;
    }
}
