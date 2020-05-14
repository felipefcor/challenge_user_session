package com.kubikdata.infrastructure;

import com.kubikdata.domain.User;
import com.kubikdata.domain.valueObjects.Username;

import java.util.HashMap;

public class InMemoryUserRepository implements UserRepositoryInterface {

    private HashMap<Username, User> userCatalog = new HashMap<>();

    public void add(Username username, User user) {
        userCatalog.put(username, user);
    }

    public User get(Username username) {
        if(userCatalog.containsKey(username)){
            User user = userCatalog.get(username);
            return user;
        }
        return null;
    }
}
