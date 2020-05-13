package user;

import com.kubikdata.domain.UserRepository;
import com.kubikdata.domain.User;
import com.kubikdata.domain.valueObjects.UserId;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;


public class UserRepositoryShould {

    @Test
    public void add_and_get_users_to_catalog(){
        UserRepository userRepository = new UserRepository();
        Username username = new Username("myUsername");
        UserId userId = new UserId(1);
        User userTest = new User(userId, username, new UserToken("usertoken"), LocalDate.now());

        userRepository.add(userId, userTest);

        Assert.assertEquals(userTest, userRepository.get(userId));
    }
}
