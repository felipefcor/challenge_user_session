package com.kubikdata.domain.user;

import com.kubikdata.domain.User;
import com.kubikdata.domain.valueObjects.IncorrectTokenException;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;
import com.kubikdata.domain.valueObjects.UsernameNotValidException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
}
