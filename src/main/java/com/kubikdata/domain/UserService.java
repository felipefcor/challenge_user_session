package com.kubikdata.domain;

import com.kubikdata.domain.valueObjects.UserId;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;

import java.time.LocalDate;

public class UserService {

    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserToken createSession(Username username) {
        UserSecurity userSecurity = new UserSecurity();
        UserToken userToken = userSecurity.createJWTToken(username);
        UserId userId = new UserId(1);
        User user = new User(userId, username, userToken, LocalDate.now());
        userRepository.add(userId, user);
        return userToken;

    }
}
