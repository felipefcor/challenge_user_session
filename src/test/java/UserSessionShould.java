import domain.UserID;
import domain.UserSession;
import domain.UserToken;
import domain.Username;

import java.time.LocalDate;

public class UserSessionShould {
    UserSession user = new UserSession(new UserID(1),
            new Username("username"),
            new UserToken("token"),
            LocalDate.now());
}
