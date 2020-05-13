package com.kubikdata.infrastructure;

import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.domain.User;
import com.kubikdata.domain.valueObjects.Username;

public interface UserRepositoryInterface {
    void add(Username username, User user);
    UserResponse get(Username username);
}
