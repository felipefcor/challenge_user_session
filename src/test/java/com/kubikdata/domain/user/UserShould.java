package com.kubikdata.domain.user;

import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.domain.User;
import com.kubikdata.domain.valueObjects.IncorrectTokenException;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class UserShould {
    User user = new User(
            new Username("username"),
            new UserToken("token"),
            LocalDate.now());

    @Test
    public void check_if_has_the_rigth_token(){
        UserToken userToken = new UserToken("token");

        Assert.assertEquals(user, user.checkToken(userToken));
    }

    @Test
    public void throw_an_exception_when_the_username_has_not_the_right_token() {
        UserToken userToken = new UserToken("wrongToken");

        Assertions.assertThrows(IncorrectTokenException.class, () -> user.checkToken(userToken));
    }

    @Test
    public void create_a_user_response_from_itself(){
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT));
        UserResponse userResponse = new UserResponse("username", "token", timestamp);

        UserResponse userResponseTest = user.createUserResponse();

        Assert.assertEquals(userResponse.getUsername(), userResponseTest.getUsername());
    }
}
