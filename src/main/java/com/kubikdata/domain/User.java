package com.kubikdata.domain;

import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.domain.valueObjects.IncorrectTokenException;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class User {
    private  Username username;
    private  UserToken token;
    private  LocalDate date;

    public User(Username username, UserToken token, LocalDate date) {
        this.username = username;
        this.token = token;
        this.date = date;
    }

    public User checkToken(UserToken userToken) {
        if (!this.token.equals(userToken)) throw new IncorrectTokenException();
         return this;
    }

    public UserResponse createUserResponse() {
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.of(this.date, LocalTime.MIDNIGHT));
        UserResponse userResponse = new UserResponse(this.username.getUsername(), this.token.toString(),timestamp);
        return userResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(token, user.token) &&
                Objects.equals(date, user.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, token, date);
    }

    @Override
    public String toString() {
        return "User{" +
                "username=" + username +
                ", token=" + token +
                ", date=" + date +
                '}';
    }
}
