package com.kubikdata.controller;

import com.kubikdata.controller.request.UserSessionRequest;
import com.kubikdata.domain.UserService;
import com.kubikdata.domain.valueObjects.Password;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;
import com.kubikdata.domain.valueObjects.UsernameNotValidException;
import com.kubikdata.infrastructure.InMemoryUserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class UserSessionController {

    private InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
    /**
     * this endpoint is needed to add a sesssion id to a specific username
     *
     * @param userSessionRequest
     * @return
     */
    @PostMapping(value = "/session")
    public ResponseEntity<Object> addSession(@RequestBody UserSessionRequest userSessionRequest) {
        UserService userService = new UserService(inMemoryUserRepository);
        HttpHeaders httpHeaders = new HttpHeaders();

        try {
            String token = userService.createSession(new Username(userSessionRequest.getUsername()), new Password(userSessionRequest.getPassword())).toString();
            httpHeaders.add("Authorization", token);


            return new ResponseEntity<>("user token created succesfully", httpHeaders, HttpStatus.CREATED);
        } catch (UsernameNotValidException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    @GetMapping(value = "/info/{username}/{token}")
    public ResponseEntity<Object> userInfoGet(@PathVariable String username, @PathVariable String token) {
        UserService userService = new UserService(inMemoryUserRepository);
        try {
            return new ResponseEntity<>(userService.get(new Username(username),new UserToken(token)), HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
