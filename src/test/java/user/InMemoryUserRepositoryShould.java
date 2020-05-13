package user;

import com.kubikdata.controller.response.UserResponse;
import com.kubikdata.domain.InMemoryUserRepository;
import com.kubikdata.domain.User;
import com.kubikdata.domain.valueObjects.UserId;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;


public class InMemoryUserRepositoryShould {

    @Test
    public void add_and_get_users_to_catalog(){
        InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
        Username username = new Username("myUsername");
        UserId userId = new UserId(1);
        User userTest = new User(userId, username, new UserToken("usertoken"), LocalDate.now());
        UserResponse userResponse = userTest.createUserResponse();

        inMemoryUserRepository.add(userId, userTest);

        Assert.assertEquals(userResponse, inMemoryUserRepository.get(userId));
    }
}
