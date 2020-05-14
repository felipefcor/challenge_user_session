package com.kubikdata.domain;

import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.controller.response.UserTokenResponse;
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

    public UserTokenResponse createSession(Username username, Password password) {
        UserSecurity userSecurity = new UserSecurity();
        UserToken userToken = userSecurity.createJWTToken(username);
        UserId userId = new UserId(1);
        User user = new User(userId, username, userToken, LocalDate.now());
        inMemoryUserRepository.add(username, user);
        return userToken.createUserTokenResponse();
    }

    public UserResponse get(Username username, UserToken userToken) {
        User user = inMemoryUserRepository.get(username);
        if (user != null && user.createUserResponse().getToken().equals(userToken.toString())) {
            return user.createUserResponse();
        }
        return null;
    }
}
