package com.kubikdata.controller;

import com.kubikdata.controller.request.UserSessionRequest;
import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.domain.valueObjects.Username;
import com.kubikdata.infrastructure.InMemoryUserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

public class UserDataRequestControllerShould {

    @Mock
    InMemoryUserRepository inMemoryUserRepository;

    @InjectMocks
    private UserDataController userDataController;

    @Test
    public void get_user_response_from_username(){
        MockitoAnnotations.initMocks(this);
        when(inMemoryUserRepository.get(new Username("username"))).thenReturn(new UserResponse("username","token", LocalDate.now()));

        ResponseEntity<UserResponse> user = userDataController.userInfoGet("username", "token");

        Assert.assertNotNull(user);
        Assert.assertEquals(HttpStatus.OK, user.getStatusCode());
    }
}
