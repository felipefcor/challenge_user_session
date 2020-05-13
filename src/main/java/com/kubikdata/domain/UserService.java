package com.kubikdata.domain;

import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.domain.valueObjects.UserId;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;

import java.time.LocalDate;

public class UserService {

    private final UserRepositoryInterface userRepository;

    public UserService(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    public UserToken createSession(Username username) {
        UserSecurity userSecurity = new UserSecurity();
        UserToken userToken = userSecurity.createJWTToken(username);
        UserId userId = new UserId(1);
        User user = new User(userId, username, userToken, LocalDate.now());
        userRepository.add(username, user);
        return userToken;
    }

    public UserResponse get(Username username) {
        UserResponse user = userRepository.get(username);
        if (user != null) return user;
        return null;
    }
}
