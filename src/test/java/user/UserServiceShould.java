package user;

import com.kubikdata.domain.IUserRepository;
import com.kubikdata.domain.User;
import com.kubikdata.domain.UserService;
import com.kubikdata.domain.valueObjects.UserId;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;


public class UserServiceShould {
   @Mock IUserRepository userRepository;

   @Test
   public void send_user_with_token_to_repository(){
      MockitoAnnotations.initMocks(this);
      Username username = new Username("myUsername");
      UserId userId = new UserId(1);
      UserService userService = new UserService(userRepository);

      UserToken userToken = userService.createSession(username);

      verify(userRepository).add(userId, new User(userId, username, userToken, LocalDate.now()));
   }

}
