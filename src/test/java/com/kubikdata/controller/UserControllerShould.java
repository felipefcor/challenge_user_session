package com.kubikdata.controller;

import com.kubikdata.controller.request.UserSessionRequest;
import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;
import com.kubikdata.infrastructure.InMemoryUserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

public class UserControllerShould {
    @Mock
    InMemoryUserRepository inMemoryUserRepository;

    @InjectMocks
    private UserSessionController userSessionController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void create_user_session_token() {
        UserSessionRequest userSessionRequest = new UserSessionRequest();
        userSessionRequest.setUsername("username");
        userSessionRequest.setPassword("password");

        ResponseEntity<Object> response = userSessionController.addSession(userSessionRequest);

        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assert.assertEquals("user token created succesfully", response.getBody());
    }

    @Test
    public void get_user_response_from_username() {
        when(inMemoryUserRepository.get(new Username("username"))).thenReturn(new UserResponse("username", "token", LocalDate.now()));

        ResponseEntity<Object> user = userSessionController.userInfoGet("username", "token");

        Assert.assertNotNull(user);
        Assert.assertEquals(HttpStatus.OK, user.getStatusCode());
    }

    @Test
    public void throw_an_error_if_username_is_not_valid() {
        UserSessionRequest userSessionRequest = new UserSessionRequest();
        userSessionRequest.setUsername("username&&");

        ResponseEntity<Object> response = userSessionController.addSession(userSessionRequest);

        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Assert.assertEquals("username not valid", response.getBody());
    }

    @Test
    public void throw_an_error_when_server_is_unavailable_and_trying_to_retrieve_user_info() {
        when(inMemoryUserRepository.get(new Username("username"))).thenThrow(new RuntimeException());

        ResponseEntity<Object> user = userSessionController.userInfoGet("username", "token");

        Assert.assertEquals(HttpStatus.SERVICE_UNAVAILABLE, user.getStatusCode());
    }

    @Test
    public void throw_an_error_if_password_is_not_valid() {
        UserSessionRequest userSessionRequest = new UserSessionRequest();
        userSessionRequest.setUsername("username");
        userSessionRequest.setPassword("user");

        ResponseEntity<Object> response = userSessionController.addSession(userSessionRequest);

        Assert.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Assert.assertEquals("password not valid", response.getBody());
    }

}
