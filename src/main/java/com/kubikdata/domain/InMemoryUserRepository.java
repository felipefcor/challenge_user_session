package com.kubikdata.domain;

import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.domain.valueObjects.UserId;

import java.util.HashMap;

public class InMemoryUserRepository implements UserRepositoryInterface {

    private HashMap<UserId, User> userCatalog = new HashMap<>();

    public void add(UserId userId, User user) {
        userCatalog.put(userId, user);
    }

    public UserResponse get(UserId userId) {
        if(userCatalog.containsKey(userId)){
            User user = userCatalog.get(userId);
            return user.createUserResponse();
        }
        return null;
    }
}
