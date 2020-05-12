package userSession;

import com.kubikdata.domain.valueObjects.UserId;
import com.kubikdata.domain.entities.User;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;

import java.time.LocalDate;

public class UserSessionShould {
    User user = new User(new UserId(1),
            new Username("username"),
            new UserToken("token"),
            LocalDate.now());
}
