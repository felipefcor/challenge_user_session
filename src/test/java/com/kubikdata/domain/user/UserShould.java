package com.kubikdata.domain.user;

import com.kubikdata.domain.User;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;

import java.time.LocalDate;

public class UserShould {
    User user = new User(
            new Username("username"),
            new UserToken("token"),
            LocalDate.now());
}
