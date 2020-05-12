package userSession;

import com.kubikdata.domain.valueObjects.UserId;
import com.kubikdata.domain.entities.UserSession;
import com.kubikdata.domain.valueObjects.UserToken;
import com.kubikdata.domain.valueObjects.Username;

import java.time.LocalDate;

public class UserSessionShould {
    UserSession user = new UserSession(new UserId(1),
            new Username("username"),
            new UserToken("token"),
            LocalDate.now());
}
