package com.kubikdata.infrastructure;

import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.infrastructure.InMemoryUserRepository;
import com.kubikdata.domain.User;
import com.kubikdata.domain.valueObjects.UserId;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;


public class InMemoryUserRepositoryShould {

    @Test
    public void add_and_get_users_to_catalog(){
        InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
        Username username = new Username("myUsername");
        User userTest = new User(new UserId(1), username, new UserToken("usertoken"), LocalDate.now());
        UserResponse userResponse = userTest.createUserResponse();

        inMemoryUserRepository.add(username, userTest);

        Assert.assertEquals(userResponse, inMemoryUserRepository.get(username));
    }
}
