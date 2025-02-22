package com.kubikdata.controller;

import com.kubikdata.controller.request.UserSessionRequest;
import com.kubikdata.domain.UserService;
import com.kubikdata.domain.valueObjects.*;
import com.kubikdata.infrastructure.InMemoryUserRepository;
import com.kubikdata.infrastructure.UserRepositoryInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserSessionController {

    private UserRepositoryInterface userRepository = new InMemoryUserRepository();
    /**
     * this endpoint is needed to add a sesssion id to a specific username
     *
     * @param userSessionRequest
     * @return
     */
    @PostMapping(value = "/session")
    public ResponseEntity<Object> addSession(@RequestBody UserSessionRequest userSessionRequest) {
        UserService userService = new UserService(userRepository);
        try {
            return new ResponseEntity<>(userService.createUserSession(new Username(userSessionRequest.getUsername()), new Password(userSessionRequest.getPassword())), HttpStatus.CREATED);
        } catch (UsernameNotValidException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (PasswordNotValidException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    @GetMapping(value = "/info/{username}/{token}")
    public ResponseEntity<Object> userInfoGet(@PathVariable String username, @PathVariable String token) {
        UserService userService = new UserService(userRepository);
        try {
            return new ResponseEntity<>(userService.getLoggedUser(new Username(username),new UserToken(token)), HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
