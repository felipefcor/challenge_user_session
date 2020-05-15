package com.kubikdata.infrastructure;

import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.domain.User;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = {"/schema.sql", "/data.sql"})
public class SQLUserRepositoryShould {

    @Autowired
    private UserRepositoryInterface sqlUserRepository;

    @Test
    public void add_and_get_users_to_catalog(){
        Username username = new Username("myUsername");
        User userTest = new User(username, new UserToken("usertoken"), LocalDate.now());
        UserResponse userResponse = userTest.createUserResponse();

        sqlUserRepository.add(username, userTest);

        Assert.assertEquals(userResponse, sqlUserRepository.get(username));
    }

}
