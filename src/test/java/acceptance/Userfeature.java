package acceptance;

import com.kubikdata.controller.response.UserTokenResponse;
import com.kubikdata.domain.valueObjects.Password;
import com.kubikdata.infrastructure.InMemoryUserRepository;
import com.kubikdata.domain.UserService;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class Userfeature {
    private InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();

    @Test
    public void create_a_user_with_a_token_and_return_a_user_response(){
        MockitoAnnotations.initMocks(this);
        Username username = new Username("myUsername");
        Password password = new Password("password");
        UserService userService = new UserService(inMemoryUserRepository);
        UserTokenResponse userTokenResponse = userService.createUserSession(username, password);
        UserToken userToken = UserToken.createFromUserTokenResponse(userTokenResponse);


        Assert.assertEquals("myUsername", userService.getLoggedUser(username, userToken).getUsername());
        Assert.assertEquals(userToken.toString(), userService.getLoggedUser(username, userToken).getToken());
    }
}
