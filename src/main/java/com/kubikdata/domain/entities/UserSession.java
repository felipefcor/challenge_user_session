package com.kubikdata.domain.entities;

import com.kubikdata.domain.valueObjects.UserId;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;

import java.time.LocalDate;

public class UserSession {
    private final UserId userID;
    private final Username username;
    private final UserToken token;
    private final LocalDate date;

    public UserSession(UserId userID, Username username, UserToken token, LocalDate date) {
        this.userID = userID;
        this.username = username;
        this.token = token;
        this.date = date;
    }

}
