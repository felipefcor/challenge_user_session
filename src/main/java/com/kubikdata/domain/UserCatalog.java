package com.kubikdata.domain;

import com.kubikdata.domain.entities.User;
import com.kubikdata.domain.valueObjects.UserId;

import java.util.HashMap;

public class UserCatalog {

    private HashMap<UserId, User> userCatalog = new HashMap<>();

    public void add(UserId userId, User user) {
        userCatalog.put(userId, user);
    }

    public User get(UserId userId) {
        if(userCatalog.containsKey(userId)) return userCatalog.get(userId);
        return null;
    }
}
