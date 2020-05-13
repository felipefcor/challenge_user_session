package com.kubikdata.controller;

import com.kubikdata.controller.request.UserSessionRequest;
import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;
import com.kubikdata.infrastructure.InMemoryUserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

public class UserSessionControllerShould {
    @Mock
    InMemoryUserRepository inMemoryUserRepository;

    @InjectMocks
    private UserSessionController userSessionController;

    @Test
    public void create_user_session_token(){
        MockitoAnnotations.initMocks(this);
        UserSessionRequest userSessionRequest = new UserSessionRequest();
        userSessionRequest.setUsername("username");

        ResponseEntity<Object> response = userSessionController.addSession(userSessionRequest);

        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assert.assertEquals("user token created succesfully", response.getBody());
    }
}
