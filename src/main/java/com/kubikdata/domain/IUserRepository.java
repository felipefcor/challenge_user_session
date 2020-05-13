package com.kubikdata.domain;

import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.domain.valueObjects.UserId;

public interface IUserRepository {
    void add(UserId userId, User user);
    UserResponse get(UserId userId);
}
