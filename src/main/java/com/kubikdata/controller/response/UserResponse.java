package com.kubikdata.controller.response;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponse that = (UserResponse) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(token, that.token) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, token, date);
    }
}
