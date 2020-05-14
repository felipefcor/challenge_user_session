package com.kubikdata.infrastructure;

import com.kubikdata.domain.User;
import com.kubikdata.domain.valueObjects.Username;

import java.util.HashMap;

public class InMemoryUserRepository implements UserRepositoryInterface {

    private HashMap<Username, User> users = new HashMap<>();

    public void add(Username username, User user) {
        users.put(username, user);
    }

    public User get(Username username) {
        if(users.containsKey(username)) return users.get(username);
        return null;
    }
}
