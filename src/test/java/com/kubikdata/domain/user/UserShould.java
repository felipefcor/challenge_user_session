package com.kubikdata.domain.user;

import com.kubikdata.domain.User;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;
import org.junit.Assert;
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
}
