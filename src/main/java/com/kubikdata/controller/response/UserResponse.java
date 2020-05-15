package com.kubikdata.controller.response;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This object will encapsulate required fields to know com.kubikdata.domain.user , token and date.
 */
public class UserResponse {

    public String username;
    public String token;
    public Timestamp date;

    public UserResponse(String username, String token, Timestamp date) {
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

    public Timestamp getDate() {
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
