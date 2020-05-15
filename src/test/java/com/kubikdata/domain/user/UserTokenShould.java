package com.kubikdata.domain.user;

import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.controller.response.UserTokenResponse;
import com.kubikdata.domain.valueObjects.UserToken;
import org.junit.Assert;
import org.junit.jupiter.api.Test;



public class UserTokenShould {
    @Test
    public void create_a_user_token_response_from_itself(){
        UserToken userToken = new UserToken("token");

        UserTokenResponse userTokenResponse = userToken.createUserTokenResponse();

        Assert.assertEquals("token", userTokenResponse.token);
    }
}
