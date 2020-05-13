package com.kubikdata.controller;

import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.domain.UserService;
import com.kubikdata.domain.valueObjects.Username;
import com.kubikdata.infrastructure.InMemoryUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * this class is used to return data info based on its session token,
 * choose one of the endpoints to return data info
 */
@RestController
public class UserDataController {

    private InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();

    @GetMapping(value = "/info/{username}/{token}")
    public ResponseEntity<UserResponse> userInfoGet(@PathVariable String username, @PathVariable String token) {
        UserService userService = new UserService(inMemoryUserRepository);
        return new ResponseEntity<>(userService.get(new Username(username)), HttpStatus.OK);

    }
}
