package com.kubikdata.domain;

import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.domain.valueObjects.Password;
import com.kubikdata.domain.valueObjects.UserId;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;
import com.kubikdata.infrastructure.InMemoryUserRepository;

import java.time.LocalDate;

public class UserService {

    private final InMemoryUserRepository inMemoryUserRepository;

    public UserService(InMemoryUserRepository inMemoryUserRepository) {
        this.inMemoryUserRepository = inMemoryUserRepository;
    }

    public UserToken createSession(Username username, Password password) {
        UserSecurity userSecurity = new UserSecurity();
        UserToken userToken = userSecurity.createJWTToken(username);
        UserId userId = new UserId(1);
        User user = new User(userId, username, userToken, LocalDate.now());
        inMemoryUserRepository.add(username, user);
        return userToken;
    }

    public UserResponse get(Username username, UserToken userToken) {
        UserResponse user = inMemoryUserRepository.get(username);
        if (user != null && user.getToken().equals(userToken.toString())) {
            return user;
        }
        return null;
    }
}
