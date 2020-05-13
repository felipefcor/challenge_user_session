package com.kubikdata.domain;

import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.domain.valueObjects.UserId;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private final UserId userID;
    private final Username username;
    private final UserToken token;
    private final LocalDate date;

    public User(UserId userID, Username username, UserToken token, LocalDate date) {
        this.userID = userID;
        this.username = username;
        this.token = token;
        this.date = date;
    }

    public UserResponse createUserResponse() {
        UserResponse userResponse = new UserResponse(this.username.getUsername(), this.token.toString(), this.date);
        return userResponse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userID, user.userID) &&
                Objects.equals(username, user.username) &&
                Objects.equals(token, user.token) &&
                Objects.equals(date, user.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, username, token, date);
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username=" + username +
                ", token=" + token +
                ", date=" + date +
                '}';
    }
}
