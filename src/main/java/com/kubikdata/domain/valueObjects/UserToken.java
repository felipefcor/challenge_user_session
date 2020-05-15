package com.kubikdata.domain.valueObjects;

import com.kubikdata.controller.response.UserTokenResponse;

import java.util.Objects;

public class UserToken {
    private String token;

    public UserToken(String token) {
        this.token = token;
    }

    public UserTokenResponse createUserTokenResponse(){
        UserTokenResponse userTokenResponse = new UserTokenResponse(this.token);
        return userTokenResponse;
    }

    public static UserToken createFromUserTokenResponse(UserTokenResponse userTokenResponse){
        UserToken userToken = new UserToken(userTokenResponse.token);
        return userToken;
    }


    @Override
    public String toString() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserToken userToken = (UserToken) o;
        return Objects.equals(token, userToken.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}
