package acceptance;

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
        UserService user = new UserService(inMemoryUserRepository);
        UserToken userToken = user.createSession(username);

        Assert.assertEquals("myUsername", user.get(username).getUsername());
        Assert.assertEquals(userToken.toString(), user.get(username).getToken());
    }
}
