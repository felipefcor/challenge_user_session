package com.kubikdata.domain;

import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.controller.response.UserTokenResponse;
import com.kubikdata.domain.valueObjects.Password;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;
import com.kubikdata.infrastructure.UserRepositoryInterface;

import java.time.LocalDate;

public class UserService {

    private final UserRepositoryInterface userRepository;

    public UserService(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    public UserTokenResponse createUserSession(Username username, Password password) {
        UserSecurity userSecurity = new UserSecurity();
        UserToken userToken = userSecurity.generateToken(username);
        User user = new User(username, userToken, LocalDate.now());
        userRepository.add(username, user);
        return userToken.createUserTokenResponse();
    }

    public UserResponse getLoggedUser(Username username, UserToken userToken) {
        User user = userRepository.get(username);
        if (user == null) return null;
        return user.checkToken(userToken).createUserResponse();

    }

}
